package org.sopt.builderExample;

import java.util.Date;

public class User2 {
    private Integer userIdx;
    private String email;
    private String password;
    private String name;
    private Integer point;
    private Date signUpAt;
    private String profileUrl;
    private String backgroundUrl;
    private String position;
    private String introduce;
    private String portfolioUrl;
    private String aim;
    private String department;
    private String area;
    private String fcmToken;

    public User2(Integer userIdx, String email, String password, String name, Integer point, Date signUpAt, String profileUrl, String backgroundUrl, String position, String introduce, String portfolioUrl, String aim, String department, String area, String fcmToken) {
        this.userIdx = userIdx;
        this.email = email;
        this.password = password;
        this.name = name;
        this.point = point;
        this.signUpAt = signUpAt;
        this.profileUrl = profileUrl;
        this.backgroundUrl = backgroundUrl;
        this.position = position;
        this.introduce = introduce;
        this.portfolioUrl = portfolioUrl;
        this.aim = aim;
        this.department = department;
        this.area = area;
        this.fcmToken = fcmToken;
    }

    public Integer getUserIdx() {
        return userIdx;
    }

    public void setUserIdx(Integer userIdx) {
        this.userIdx = userIdx;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPoint() {
        return point;
    }

    public void setPoint(Integer point) {
        this.point = point;
    }

    public Date getSignuUpAt() {
        return signUpAt;
    }

    public void setSignupAt(Date signupAt) {
        this.signUpAt = signupAt;
    }

    public String getProfileUrl() {
        return profileUrl;
    }

    public void setProfileUrl(String profileUrl) {
        this.profileUrl = profileUrl;
    }

    public String getBackgroundUrl() {
        return backgroundUrl;
    }

    public void setBackgroundUrl(String backgroundUrl) {
        this.backgroundUrl = backgroundUrl;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }

    public String getPortfolioUrl() {
        return portfolioUrl;
    }

    public void setPortfolioUrl(String portfolioUrl) {
        this.portfolioUrl = portfolioUrl;
    }

    public String getAim() {
        return aim;
    }

    public void setAim(String aim) {
        this.aim = aim;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getFcmToken() {
        return fcmToken;
    }

    public void setFcmToken(String fcmToken) {
        this.fcmToken = fcmToken;
    }

    @Override
    public String toString() {
        return "User2{" +
                "userIdx=" + userIdx +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", point=" + point +
                ", signUpAt=" + signUpAt +
                ", profileUrl='" + profileUrl + '\'' +
                ", backgroundUrl='" + backgroundUrl + '\'' +
                ", position='" + position + '\'' +
                ", introduce='" + introduce + '\'' +
                ", portfolioUrl='" + portfolioUrl + '\'' +
                ", aim='" + aim + '\'' +
                ", department='" + department + '\'' +
                ", area='" + area + '\'' +
                ", fcmToken='" + fcmToken + '\'' +
                '}';
    }
}
