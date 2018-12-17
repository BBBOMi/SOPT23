package org.sopt.review.seminar7.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.sopt.review.seminar7.dto.User;
import org.sopt.review.seminar7.mapper.UserMapper;
import org.sopt.review.seminar7.model.DefaultRes;
import org.sopt.review.seminar7.model.SignUpReq;
import org.sopt.review.seminar7.service.S3FileUploadService;
import org.sopt.review.seminar7.service.UserService;
import org.sopt.review.seminar7.utils.Message;
import org.sopt.review.seminar7.utils.Status;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

/**
 * Created by bomi on 2018-12-17.
 */

@Slf4j
@Service
public class UserServiceImpl implements UserService {

    final UserMapper userMapper;
    final S3FileUploadService s3FileUploadService;

    public UserServiceImpl(final UserMapper userMapper, final S3FileUploadService s3FileUploadService) {
        this.userMapper = userMapper;
        this.s3FileUploadService = s3FileUploadService;
    }

    /**
     * 회원 조회(마이페이지 조회)
     * @param userIdx
     *      조회할 userIdx
     * @return 결과를 담은 data 객체
     */
    @Override
    public DefaultRes getUser(final int userIdx) {
        User user = userMapper.findUser(userIdx);
        if(user != null) {
            return DefaultRes.res(Status.OK, Message.SUCCEED_GET_USER, user);
        }
        return DefaultRes.res(Status.NOT_FOUND, Message.NOT_FOUND_USER);
    }

    @Override
    @Transactional
    public DefaultRes addUser(final SignUpReq signUpReq) {
        if(signUpReq.checkProperties()) {
            String email = signUpReq.getEmail();
            // 이메일 중복 확인
            if(userMapper.findByEmail(email) > 0) {
                return DefaultRes.res(Status.BAD_REQUEST, Message.DUPLICATE_EMAIL);
            } else {
                try {
                    if(signUpReq.getProfile() != null) {
                        signUpReq.setProfileUrl(s3FileUploadService.upload(signUpReq.getProfile()));
                    }
                    userMapper.signUpUser(signUpReq);
                    return DefaultRes.res(Status.CREATED, Message.CREATE_USER);
                } catch(Exception e) {
                    // Rollback
                    TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
                    log.error(e.getMessage());
                    return DefaultRes.res(Status.DB_ERROR, Message.DB_ERROR);
                }
            }
        }
        return DefaultRes.res(Status.BAD_REQUEST, Message.FAIL_CREAT_USER);
    }

    @Override
    @Transactional
    public DefaultRes update(SignUpReq signUpReq) {
        return null;
    }

    @Override
    @Transactional
    public DefaultRes deleteUser(final int userIdx) {
        return null;
    }
}
