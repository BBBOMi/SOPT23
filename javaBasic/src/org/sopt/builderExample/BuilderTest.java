package org.sopt.builderExample;

public class BuilderTest {
    public static void main(String[] args) {
        // builder 없이 생성자를 이용해 객체 생성 -> 불편
        final User2 user = new User2(1, "pm@cowalker.com", "1234", "이충엽", 0, null,
                "imgPath", "ImgPath", "개설자", "안녕하세요", "ImgPath", "메인기획자", null, "의정부", "tokenValue" );

        // builder 사용의 예
        // builder를 사용하면 조금 더 명시적이고 명확하게 객체 생성 가능
        final UserBuilder user2Builder = new UserBuilder();
        final User2 designer = user2Builder.setUserIdx(4)
                .setEmail("designer@cowalker.com")
                .setPassword("0000")
                .setName("박채원")
                .setPoint(0)
                .setSignUpAt(null)
                .setProfileUrl("ImgPath")
                .setPosition("디자이너")
                .setIntroduce("웹 디자이너입니다")
                .setPortfolioUrl("ImgPath")
                .setAim(null)
                .setArea("수원")
                .setBackgroundUrl(null)
                .setFcmToken(null)
                .setDepartment(null)
                .build();

        System.out.println(user);
        System.out.println(designer);
    }
}
