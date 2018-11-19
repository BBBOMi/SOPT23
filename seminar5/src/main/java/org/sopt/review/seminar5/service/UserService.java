package org.sopt.review.seminar5.service;

import lombok.extern.slf4j.Slf4j;

import org.sopt.review.seminar5.dto.User;
import org.sopt.review.seminar5.mapper.UserMapper;
import org.sopt.review.seminar5.model.DefaultRes;
import org.sopt.review.seminar5.model.SignUpReq;
import org.sopt.review.seminar5.utils.ResponseMessage;
import org.sopt.review.seminar5.utils.StatusCode;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.util.List;

/**
 * Created by bomi on 2018-11-13.
 * Modified by bomi on 2018-11-19.
 */

@Slf4j
@Service
public class UserService {

    private final UserMapper userMapper;
    // UserService에서 파일 업로드(사진 업로드)를 위해 추가
    private final S3FileUploadService s3FileUploadService;

    /**
     * UserMapper 생성자 의존성 주입
     * @param userMapper
     * @param s3FileUploadService
     */
    public UserService(final UserMapper userMapper, final S3FileUploadService s3FileUploadService) {
        this.userMapper = userMapper;
        this.s3FileUploadService = s3FileUploadService;
    }

    /**
     * 모든 회원 조회
     * @return 상태코드와 메세지, 결과 데이터를 가지고 있는 DefaultRes
     */
    public DefaultRes getAllUsers() {
        final List<User> list = userMapper.findAll();
        if(list.isEmpty()) {
            return DefaultRes.res(StatusCode.NOT_FOUND, ResponseMessage.NOT_FOUND_USER);
        } else {
            return DefaultRes.res(StatusCode.OK, ResponseMessage.READ_USER, list);
        }
    }

    /**
     * 이름으로 회원 조회
     * @param name
     *      조회할 회원의 이름
     * @return 상태코드와 메세지, 결과 데이터를 가지고 있는 DefaultRes
     */
    public DefaultRes findByName(final String name) {
        final List<User> list = userMapper.findByName(name);
        if(list.isEmpty()) {
            return DefaultRes.res(StatusCode.NOT_FOUND, ResponseMessage.NOT_FOUND_USER);
        } else {
            return DefaultRes.res(StatusCode.OK, ResponseMessage.READ_USER, list);
        }
    }

    /**
     * 회원 가입
     * @param signUpReq
     *      가입할 회원 데이터
     * @return 상태코드와 메세지, 결과 데이터를 가지고 있는 DefaultRes
     */
    @Transactional
    public DefaultRes save(SignUpReq signUpReq) {
        try {
            if(signUpReq.getProfile() != null) {
                signUpReq.setProfileUrl(s3FileUploadService.upload(signUpReq.getProfile()));
            }
            userMapper.save(signUpReq);
            return DefaultRes.res(StatusCode.CREATED, ResponseMessage.CREATED_USER);
        } catch(Exception e) {
            // Rollback
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            log.error(e.getMessage());
            return DefaultRes.res(StatusCode.DB_ERROR, ResponseMessage.DB_ERROR);
        }
    }

    /**
     * 회원 정보 수정
     * @param userIdx
     *      정보를 수정할 회원의 고유 번호
     * @param user
     *      수정할 회원 데이터
     * @return 상태코드와 메세지, 결과 데이터를 가지고 있는 DefaultRes
     */
    @Transactional
    public DefaultRes update(final int userIdx, final User user) {
        final User temp = userMapper.findByUserIdx(userIdx);
        if(temp == null) {
            return DefaultRes.res(StatusCode.NOT_FOUND, ResponseMessage.NOT_FOUND_USER);
        }

        try {
             if(user.getName() != null) {
                 temp.setName(user.getName());
             }
             if(user.getPart() != null) {
                 temp.setPart(user.getPart());
             }
            userMapper.update(userIdx, temp);
            return DefaultRes.res(StatusCode.OK, ResponseMessage.UPDATE_USER);
        } catch(Exception e) {
            // Rollback
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            log.error(e.getMessage());
            return DefaultRes.res(StatusCode.DB_ERROR, ResponseMessage.DB_ERROR);
        }
    }

    /**
     * 회원 탈퇴
     * @param userIdx
     *      탈퇴할 회원의 고유 번호
     * @return 상태코드와 메세지, 결과 데이터를 가지고 있는 DefaultRes
     */
    public DefaultRes deleteByUserIdx(final int userIdx) {
        final User user = userMapper.findByUserIdx(userIdx);
        if(user == null) {
            return DefaultRes.res(StatusCode.NOT_FOUND, ResponseMessage.NOT_FOUND_USER);
        }

        try {
            userMapper.deleteByUserIdx(userIdx);
            return DefaultRes.res(StatusCode.NO_CONTENT, ResponseMessage.DELETE_USER);
        } catch(Exception e) {
            // Rollback
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            log.error(e.getMessage());
            return DefaultRes.res(StatusCode.DB_ERROR, ResponseMessage.DB_ERROR);
        }
    }
}
