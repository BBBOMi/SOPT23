package org.sopt.review.seminar5.model;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

/**
 * Created by bomi on 2018-11-19.
 */

// 회원 가입, 회원 정보 수정 시 받을 객체
@Data
public class SignUpReq {
    private String name;
    private String password;
    private String part;

    // 프로필 사진 객체
    private MultipartFile profile;
    // 프로필 사진 저장 url 주소
    private String profileUrl;
}
