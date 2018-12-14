package org.sopt.review.seminar7.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.sopt.review.seminar7.service.JwtService;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * Created by bomi on 2018-12-14.
 */

@Slf4j
@Service
public class JwtServiceImpl implements JwtService {
    @Override
    public String create(int userIdx) {
        return null;
    }

    @Override
    public Date expiresAt() {
        return null;
    }

    @Override
    public Token decode(String token) {
        return null;
    }

    public static class Token {
        private int userIdx;

        public Token() {}
        public Token(final int userIdx) {
            this.userIdx = userIdx;
        }

        public int getUserIdx() {
            return userIdx;
        }
    }

    // 반환될 토큰Res
    public static class TokenRes {
        // 실제 토큰
        private String token;

        public TokenRes() {}
        public TokenRes(final String token) {
            this.token = token;
        }

        public String getToken() {
            return token;
        }

        public void setToken(String token) {
            this.token = token;
        }
    }
}
