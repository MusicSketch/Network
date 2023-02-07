package com.greedy.thymeleaf.controller;

import com.greedy.thymeleaf.model.dto.MusiclistDTO;
import com.greedy.thymeleaf.model.dto.ResponseDTO;
import com.greedy.thymeleaf.model.service.MusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class MainController {
    // 시작페이지는 index.html 사용

    private final MusicService musicService;
    private final MessageSource messageSource;

    @Autowired
    public MainController(MusicService musicService, MessageSource messageSource) {
        this.musicService = musicService;
        this.messageSource = messageSource;
    }

    //메인페이지
    @GetMapping("/main")
    public ModelAndView main(ModelAndView mv){

        List<MusiclistDTO> dancelist = musicService.searchMusicByDance();
        List<MusiclistDTO> baladlist = musicService.searchMusicByBalad();

        mv.addObject("dancelist", dancelist);
        mv.addObject("baladlist", baladlist);
        mv.setViewName("/main/main");

        return mv;
    }

}
