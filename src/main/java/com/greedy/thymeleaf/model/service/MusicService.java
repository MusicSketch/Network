package com.greedy.thymeleaf.model.service;

import com.greedy.thymeleaf.model.dao.MusicMapper;
import com.greedy.thymeleaf.model.dto.MusiclistDTO;
import com.greedy.thymeleaf.model.dto.ResponseDTO;
import com.greedy.thymeleaf.paging.SelectCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class MusicService {

    private final MusicMapper musicMapper;

    @Autowired
    public MusicService(MusicMapper musicMapper) { this.musicMapper = musicMapper; }

    public int selectTotalCount() {

        int result = musicMapper.selectTotalCount();

        return result;
    }

    public List<MusiclistDTO> searchMusicByDance() {

        return musicMapper.searchMusicByDance();
    }

    public List<MusiclistDTO> searchMusicByBalad() {

        return musicMapper.searchMusicByBalad();
    }

//    public List<ResponseDTO> findResultList(SelectCriteria selectCriteria) {
//
//        return musicMapper.findResultList(selectCriteria);
//    }

    public List<ResponseDTO> findResultList(SelectCriteria selectCriteria) {
        List<ResponseDTO> tempdto = musicMapper.findResultList(selectCriteria);
       // musicMapper.delete();
        return tempdto;
    }



    public List<MusiclistDTO> AllMusicList(SelectCriteria selectCriteria) {

        List<MusiclistDTO> boardList = musicMapper.AllMusicList(selectCriteria);

        return boardList;
    }

    @Transactional
    public void tempList(ResponseDTO songId) {
        musicMapper.tempList(songId);
    }

    public void delete() {

        musicMapper.delete();
    }
}
