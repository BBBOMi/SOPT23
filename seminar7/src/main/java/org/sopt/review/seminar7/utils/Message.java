package org.sopt.review.seminar7.utils;

/**
 * Created by bomi on 2018-12-13.
 */

public enum Message {
    SUCCEED_LOGIN("로그인 성공"),
    FAIL_LOGIN("로그인 실패"),

    CREATE_USER("회원 가입 성공"),
    FAIL_CREAT_USER("회원 가입 실패"),
    DUPLICATE_EMAIL("이미 존재하는 email 입니다"),

    SUCCEED_UPDATE("회원 정보 수정 성공"),
    FAILE_UPDATE("회원 정보 수정 실패"),

    UNAUTHORIZED("인증 실패"),

    SUCCEED_GET_USER("회원 조회 성공"),
    NOT_FOUND_USER("회원을 찾을 수 없습니다"),

    DELETE_USER("회원 탈퇴 성공"),

    INTERNAL_SERVER_ERROR("서버 내부 에러"),
    DB_ERROR("데이터베이스 에러");

    private String message;
    Message(final String message) {
        this.message = message;
    }

}
