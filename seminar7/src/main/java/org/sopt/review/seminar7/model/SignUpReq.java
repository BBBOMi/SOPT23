package org.sopt.review.seminar7.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

/**
 * Created by bomi on 2018-12-17.
 */

@Data
@NoArgsConstructor
public class SignUpReq {
    private String name; // 이름
    private String email; // 이메일
    private String password; // 비밀번호
    private MultipartFile profile; // 프로필 사진
    private String profileUrl; // 프로필 사진 저장 url 주소

    public boolean checkProperties() {
        return (email != null & name != null & password != null);
    }
}
