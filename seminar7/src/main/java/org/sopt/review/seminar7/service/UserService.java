package org.sopt.review.seminar7.service;

import org.sopt.review.seminar7.model.DefaultRes;
import org.sopt.review.seminar7.model.SignUpReq;

/**
 * Created by bomi on 2018-12-17.
 */

public interface UserService {
    DefaultRes getUser(final int userIdx); // 회원 조회
    DefaultRes addUser(final SignUpReq signUpReq); // 회원 가임
    DefaultRes update(SignUpReq signUpReq); // 회원 정보 업데이트
    DefaultRes deleteUser(final int userIdx); // 회원 탈퇴
}
