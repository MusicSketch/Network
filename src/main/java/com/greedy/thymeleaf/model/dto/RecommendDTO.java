package com.greedy.thymeleaf.model.dto;

public class RecommendDTO {

    private int recommendCode;
    private int memberCode;
    private int musicCode;

    public RecommendDTO() {}

    public RecommendDTO(int recommendCode, int memberCode, Integer musicCode) {
        this.recommendCode = recommendCode;
        this.memberCode = memberCode;
        this.musicCode = musicCode;
    }

    public int getRecommendCode() {
        return recommendCode;
    }

    public void setRecommendCode(int recommendCode) {
        this.recommendCode = recommendCode;
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

    @Override
    public String toString() {
        return "RecommendDTO{" +
                "recommendCode=" + recommendCode +
                ", memberCode=" + memberCode +
                ", musicCode=" + musicCode +
                '}';
    }


}
