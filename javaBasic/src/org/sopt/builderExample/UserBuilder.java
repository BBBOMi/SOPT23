package org.sopt.builderExample;

import java.util.Date;

/**
 * Builder Pattern
 * 1. 생성자에 들어갈 매개변수를 차례대로 받아들이고 모든 매개변수를 받은 뒤에 이 변수들을 통합하여 한번에 사용
 * 2. 데이터의 순서에 상관 없이 객체를 만든다
 * 3. 사용자가 봤을 때 명시적이고 명확하게 이해할 수 있어야한다.
 * 4. 불필요한 생성자를 만들지 않고 객체를 만든다.
 */

public class UserBuilder {
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

    public UserBuilder setUserIdx(Integer userIdx) {
        this.userIdx = userIdx;
        return this;
    }

    public UserBuilder setEmail(String email) {
        this.email = email;
        return this;
    }

    public UserBuilder setPassword(String password) {
        this.password = password;
        return this;
    }

    public UserBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public UserBuilder setPoint(Integer point) {
        this.point = point;
        return this;
    }

    public UserBuilder setSignUpAt(Date signUpAt) {
        this.signUpAt = signUpAt;
        return this;
    }

    public UserBuilder setProfileUrl(String profileUrl) {
        this.profileUrl = profileUrl;
        return this;
    }

    public UserBuilder setBackgroundUrl(String backgroundUrl) {
        this.backgroundUrl = backgroundUrl;
        return this;
    }

    public UserBuilder setPosition(String position) {
        this.position = position;
        return this;
    }

    public UserBuilder setIntroduce(String introduce) {
        this.introduce = introduce;
        return this;
    }

    public UserBuilder setPortfolioUrl(String portfolioUrl) {
        this.portfolioUrl = portfolioUrl;
        return this;
    }

    public UserBuilder setAim(String aim) {
        this.aim = aim;
        return this;
    }

    public UserBuilder setDepartment(String department) {
        this.department = department;
        return this;
    }

    public UserBuilder setArea(String area) {
        this.area = area;
        return this;
    }

    public UserBuilder setFcmToken(String fcmToken) {
        this.fcmToken = fcmToken;
        return this;
    }

    /**
     * User Builder
     * @return User객체
     */
    public User2 build() {
        return new User2(this.userIdx, this.email, this.password, this.name, this.point, this.signUpAt, this.profileUrl,
                this.backgroundUrl, this.position, this.introduce, this.portfolioUrl, this.aim, this.department, this.area, this.fcmToken);
    }
}
