package com.greedy.thymeleaf.model.dto;

public class ResponseDTO {
    private long songId;

    public ResponseDTO(){}

    public long getSongId() {
        return songId;
    }

    public void setSongId(long songId) {
        this.songId = songId;
    }

    @Override
    public String toString() {
        return "responseDTO{" +
                "songId=" + songId +
                '}';
    }
}
