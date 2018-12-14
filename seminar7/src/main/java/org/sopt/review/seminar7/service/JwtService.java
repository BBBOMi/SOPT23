package org.sopt.review.seminar7.service;

import org.sopt.review.seminar7.service.impl.JwtServiceImpl;

import java.util.Date;

/**
 * Created by bomi on 2018-12-14.
 */

public interface JwtService {
    String create(final int userIdx);
    Date expiresAt();
    JwtServiceImpl.Token decode(final String token);
}
