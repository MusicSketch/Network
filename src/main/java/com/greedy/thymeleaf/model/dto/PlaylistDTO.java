package com.greedy.thymeleaf.model.dto;

public class PlaylistDTO {

    private int listCode;
    private int memberCode;
    private int musicCode;
    private int playTime;

    public PlaylistDTO() {}

    public PlaylistDTO(int listCode, int memberCode, Integer musicCode, int playTime) {
        this.listCode = listCode;
        this.memberCode = memberCode;
        this.musicCode = musicCode;
        this.playTime = playTime;
    }

    public int getListCode() {
        return listCode;
    }

    public void setListCode(int listCode) {
        this.listCode = listCode;
    }

    public int getMemberCode() {
        return memberCode;
    }

    public void setMemberCode(int memberCode) {
        this.memberCode = memberCode;
    }

    public int getMusicCode() {
        return musicCode;
    }

    public void setMusicCode(int musicCode) {
        this.musicCode = musicCode;
    }

    public int getPlayTime() {
        return playTime;
    }

    public void setPlayTime(int playTime) {
        this.playTime = playTime;
    }

    @Override
    public String toString() {
        return "PlaylistDTO{" +
                "listCode=" + listCode +
                ", memberCode=" + memberCode +
                ", musicCode=" + musicCode +
                ", playTime=" + playTime +
                '}';
    }
}
