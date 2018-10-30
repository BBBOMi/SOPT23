package org.sopt.review.seminar3.lombok;

/**
 * Created by bomi on 2018-10-29.
 */

public class Main {

    public static void main(String[] args) {
        Test test = new Test();

        // @Data가 다양한 메소드를 자동으로 만들어준다
        TestData testData = new TestData();
        testData.getEmail();
        testData.setUserIdx(0);
        testData.toString();

        // Getter, Setter 메소드 자동 생성
        TestGetterSetter testGetterSetter = new TestGetterSetter();
        testGetterSetter.setEmail("qhal1215@naver.com");
        testGetterSetter.getUserIdx();

        // 모든 필드의 생성자 자동 생성
        TestAllArgsConstructor testAllArgsConstructor = new TestAllArgsConstructor(1, "김보미", "qhal1215@naver.com");

        // NullPointerException 발생
        TestNonNull testNonNull = new TestNonNull(0, null, null);

        // @NonNull, final 붙은 키워드의 생성자 자동 생성
        TestRequiredArgsConstructor testRequiredArgsConstructor
                = new TestRequiredArgsConstructor("김보미", "qhal1215@naver.com");

        // Builder 클래스 생성
        TestBuilder.TestBuilderBuilder builder = new TestBuilder.TestBuilderBuilder();
        // Builder 메소드로 Build
        TestBuilder.builder()
                .userIdx(1)
                .name("김보미")
                .email("qhal1215@naver.com")
                .build();

        // immutable 객체 생성
        TestValue testValue = new TestValue(0, "김보미", "qhal1215@naver.com");
        // @Wither이 붙은 필드 값을 변경한 새로운 객체를 만들어준다
        TestValue testValue1 = testValue.withUserIdx(1);
    }
}
