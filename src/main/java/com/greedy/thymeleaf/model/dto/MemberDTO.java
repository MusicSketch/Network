package com.greedy.thymeleaf.model.dto;

public class MemberDTO {

    private int memberCode;
    private String memberId;
    private String memberPwd;
    private String email;
    private String auth;

    public MemberDTO() {}

    public MemberDTO(int memberCode, String memberId, String memberPwd, String email, String auth) {
        this.memberCode = memberCode;
        this.memberId = memberId;
        this.memberPwd = memberPwd;
        this.email = email;
        this.auth = auth;
    }

    public int getMemberCode() {
        return memberCode;
    }

    public void setMemberCode(int memberCode) {
        this.memberCode = memberCode;
    }

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public String getMemberPwd() {
        return memberPwd;
    }

    public void setMemberPwd(String memberPwd) {
        this.memberPwd = memberPwd;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAuth() {
        return auth;
    }

    public void setAuth(String auth) {
        this.auth = auth;
    }

    @Override
    public String toString() {
        return "MemberDTO{" +
                "memberCode=" + memberCode +
                ", memberId='" + memberId + '\'' +
                ", memberPwd='" + memberPwd + '\'' +
                ", email='" + email + '\'' +
                ", auth='" + auth + '\'' +
                '}';
    }
}
