package com.greedy.thymeleaf.model.dao;

import com.greedy.thymeleaf.model.dto.MusiclistDTO;
import com.greedy.thymeleaf.model.dto.ResponseDTO;
import com.greedy.thymeleaf.paging.SelectCriteria;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MusicMapper {
    List<MusiclistDTO> searchMusicByDance();

    List<MusiclistDTO> searchMusicByBalad();

    List<MusiclistDTO> AllMusicList(SelectCriteria selectCriteria);

    int selectTotalCount();

    List<ResponseDTO> findResultList(SelectCriteria selectCriteria);

    void tempList(ResponseDTO songId);

    void delete();

}
