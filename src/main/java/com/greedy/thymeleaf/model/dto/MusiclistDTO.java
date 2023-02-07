package com.greedy.thymeleaf.model.dto;

public class MusiclistDTO {

    private String musicTitle;
    private String musicGenre;
    private String musicSinger;
    private int musicCode;

    public MusiclistDTO() {}

    public MusiclistDTO(String musicTitle, String musicGenre, String musicSinger, int musicCode) {
        this.musicTitle = musicTitle;
        this.musicGenre = musicGenre;
        this.musicSinger = musicSinger;
        this.musicCode = musicCode;
    }

    public String getMusicTitle() {
        return musicTitle;
    }

    public void setMusicTitle(String musicTitle) {
        this.musicTitle = musicTitle;
    }

    public String getMusicGenre() {
        return musicGenre;
    }

    public void setMusicGenre(String musicGenre) {
        this.musicGenre = musicGenre;
    }

    public String getMusicSinger() {
        return musicSinger;
    }

    public void setMusicSinger(String musicSinger) {
        this.musicSinger = musicSinger;
    }

    public int getMusicCode() {
        return musicCode;
    }

    public void setMusicCode(int musicCode) {
        this.musicCode = musicCode;
    }

    @Override
    public String toString() {
        return "MusiclistDTO{" +
                "musicTitle='" + musicTitle + '\'' +
                ", musicGenre='" + musicGenre + '\'' +
                ", musicSinger='" + musicSinger + '\'' +
                ", musicCode=" + musicCode +
                '}';
    }
}
