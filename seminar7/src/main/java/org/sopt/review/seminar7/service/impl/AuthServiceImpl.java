package org.sopt.review.seminar7.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.sopt.review.seminar7.dto.User;
import org.sopt.review.seminar7.mapper.UserMapper;
import org.sopt.review.seminar7.model.DefaultRes;
import org.sopt.review.seminar7.model.LoginReq;
import org.sopt.review.seminar7.service.AuthService;
import org.sopt.review.seminar7.service.JwtService;
import org.sopt.review.seminar7.utils.Message;
import org.sopt.review.seminar7.utils.Status;
import org.springframework.stereotype.Service;

/**
 * Created by bomi on 2018-12-17.
 */

@Slf4j
@Service
public class AuthServiceImpl implements AuthService {
    private final UserMapper userMapper;
    private final JwtService jwtService;

    public AuthServiceImpl(final UserMapper userMapper, final JwtService jwtService) {
        this.userMapper = userMapper;
        this.jwtService = jwtService;
    }

    @Override
    public DefaultRes<JwtServiceImpl.TokenRes> login(LoginReq loginReq) {
        final User user = userMapper.findByEmailAndPassword(loginReq.getEmail(), loginReq.getPassword());
        if(user != null) {
            // 토큰 생성
            final JwtServiceImpl.TokenRes tokenDto = new JwtServiceImpl.TokenRes(jwtService.create(user.getUserIdx()));
            return DefaultRes.res(Status.OK, Message.SUCCEED_LOGIN, tokenDto);
        }
        return DefaultRes.res(Status.BAD_REQUEST, Message.FAIL_LOGIN);
    }
}
