package com.greedy.thymeleaf.controller;

import com.greedy.thymeleaf.model.dto.MusiclistDTO;
import com.greedy.thymeleaf.model.dto.ResponseDTO;
import com.greedy.thymeleaf.model.service.MusicService;
import com.greedy.thymeleaf.paging.Pagenation;
import com.greedy.thymeleaf.paging.SelectCriteria;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.sound.sampled.*;
import java.io.*;
import java.util.Base64;
import java.util.List;

@Controller
@RequestMapping("/findmusic")
public class FindMusicController {

    private final MusicService musicService;
    private final MessageSource messageSource;

    @Autowired
    public FindMusicController(MusicService musicService, MessageSource messageSource) {
        this.musicService = musicService;
        this.messageSource = messageSource;
    }

    //나에게 맞는 음악 찾기
    @GetMapping
    public ModelAndView findmusic(ModelAndView mv){

        mv.setViewName("/findmusic/findmusic");

        return mv;
    }

    //나에게 맞는 음악 결과화면
    @GetMapping("/result")
    public ModelAndView result(HttpServletRequest request, ModelAndView mv){

        String currentPage = request.getParameter("currentPage");
        int pageNo = 1;

        if(currentPage != null && !"".equals(currentPage)) {
            pageNo = Integer.parseInt(currentPage);
        }

        int totalCount = musicService.selectTotalCount();

        /* 한 페이지에 보여 줄 게시물 수 */
        int limit = 10;		//얘도 파라미터로 전달받아도 된다.

        /* 한 번에 보여질 페이징 버튼의 갯수 */
        int buttonAmount = 5;

        /* 페이징 처리를 위한 로직 호출 후 페이징 처리에 관한 정보를 담고 있는 인스턴스를 반환받는다. */
        SelectCriteria selectCriteria = null;
        selectCriteria = Pagenation.getSelectCriteria(pageNo, totalCount, limit, buttonAmount);

//        List<MusiclistDTO> musicList = musicService.AllMusicList();
        List<ResponseDTO> resultList = musicService.findResultList(selectCriteria);

        mv.addObject("musicList", resultList);
        mv.addObject("selectCriteria", selectCriteria);

        mv.setViewName("/findmusic/result");

        return mv;
    }

    @DeleteMapping  ("/findmusic/delete")
    public void delete() {
        musicService.delete();
    }

    @PostMapping("/modelresult")
    public ResponseEntity<Message> modelresult(@RequestBody String result){
        System.out.println("ID: " + result);

        return ResponseEntity.ok(new Message(200, "result recieve"));
    }

    //최근 추천 목록 보기
    @GetMapping("/list")
    public ModelAndView list(ModelAndView mv){

        return mv;
    }

    //녹음 파일 전송
    @CrossOrigin
    @PostMapping("/upload")
    public ResponseEntity<Message> recordupload(@ModelAttribute ResponseDTO dto, @RequestParam("data") MultipartFile wav) throws IOException, UnsupportedAudioFileException {

        //통신

        byte[] array = wav.getBytes();

        System.out.println(array.length);

//        String uploadedFileLocation = "D:\\test\\";
//        wav.transferTo(new File(uploadedFileLocation + "voice.webm"));

        String recordfile = Base64.getEncoder().encodeToString(array);


        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.MULTIPART_FORM_DATA);

        MultiValueMap<String, String> body
                = new LinkedMultiValueMap<>();
        body.add("file", recordfile);

        HttpEntity<MultiValueMap<String, String>> requestEntity
                = new HttpEntity<>(body, headers);

        String serverUrl = "http://192.168.0.71:5000/";

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<?> response = restTemplate
                .postForEntity(serverUrl, requestEntity, String.class);


        System.out.println(response.getBody());

        String jsonData = (String) response.getBody();

        //통신 x
//        String jsonData =
//                "[{\"song_id\":0},{\"song_id\":1},{\"song_id\":2},{\"song_id\":3},{\"song_id\":4},{\"song_id\":5},{\"song_id\":6},{\"song_id\":7},{\"song_id\":8},{\"song_id\":9},{\"song_id\":10},{\"song_id\":11},{\"song_id\":12},{\"song_id\":13},{\"song_id\":14},{\"song_id\":15},{\"song_id\":16},{\"song_id\":17},{\"song_id\":18},{\"song_id\":19},{\"song_id\":20},{\"song_id\":21},{\"song_id\":22},{\"song_id\":23},{\"song_id\":24},{\"song_id\":25},{\"song_id\":26},{\"song_id\":27},{\"song_id\":28},{\"song_id\":29}]";

        String data = "{ \"data\" : " + jsonData + "}";
        System.out.println("datadata : " + data);
        JSONParser parser = new JSONParser();
        Object ob = null;
        try {
            ob = parser.parse(data);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

        //타입캐스팅
        JSONObject js = (JSONObject) ob;
        //리스트로 변환
        List<JSONObject> jsList = (List) js.get("data");

        System.out.println(jsList);
        System.out.println(jsList.get(0).get("song_id"));


        //ResponseDTO dto = new ResponseDTO();

        long[] temp = new long[30];

        for(int i=0;i<jsList.size();i++){
            temp[i] = (long) jsList.get(i).get("song_id");
            dto.setSongId(temp[i]);
            musicService.tempList(dto);
        }

        return ResponseEntity.ok(new Message(200, "ok"));
    }

}