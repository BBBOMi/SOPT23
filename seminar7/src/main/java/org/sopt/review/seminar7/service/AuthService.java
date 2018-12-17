package org.sopt.review.seminar7.service;

import org.sopt.review.seminar7.model.DefaultRes;
import org.sopt.review.seminar7.model.LoginReq;
import org.sopt.review.seminar7.service.impl.JwtServiceImpl;

/**
 * Created by bomi on 2018-12-14.
 */


public interface AuthService {
    DefaultRes<JwtServiceImpl.TokenRes> login(final LoginReq loginReq);
}
