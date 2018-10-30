package org.sopt.review.seminar3.lombok;

/**
 * Created by bomi on 2018-10-29.
 */

import lombok.NoArgsConstructor;

/**
 * @NoArgsConstructor
 * Default 생성자 자동 생성
 * 같은 기능의 생성자가 이미 존재할 경우 컴파일 에러
 */

@NoArgsConstructor
public class TestNoArgsConstructor {
    private int userIdx;
    private String name;
    private String email;

    // Default 생성자 자동 생성
    // public TestNoArgsConstructor() {}
}
