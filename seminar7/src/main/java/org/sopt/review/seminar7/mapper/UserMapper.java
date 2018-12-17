package org.sopt.review.seminar7.mapper;

import org.apache.ibatis.annotations.*;
import org.sopt.review.seminar7.dto.User;
import org.sopt.review.seminar7.model.SignUpReq;

/**
 * Created by bomi on 2018-12-17.
 */

@Mapper
public interface UserMapper {
    // 로그인
    @Select("SELECT userIdx, name, email, password, profileUrl FROM user WHERE email = #{email} AND password = #{password}")
    User findByEmailAndPassword(@Param("email") final String email, @Param("password") final String password);

    // 회원 조회
    @Select("SELECT userIdx, name, email, password, profileUrl FROM user WHERE userIdx = #{userIdx}")
    User findUser(@Param("userIdx") final int userIdx);

    @Insert("SELECT COUNT(email) FROM user WHERE email = #{email}")
    int findByEmail(@Param("email") final String email);

    // 회원 가입
    @Insert("INSERT INTO user(name, email, password, profileUrl) VALUES(#{signUpReq.name}, #{signUpReq.email}, #{signUpReq.password}, #{signUpReq.profile}")
    @Options(useGeneratedKeys = true, keyColumn = "user.userIdx")
    void signUpUser(@Param("signUpReq") final SignUpReq signUpReq);

    // 회원 정보 수정
    @Update("UPDATE user SET name = #{signUpReq.name}, email = #{signUpReq.email}, password = #{signUpReq.password}, profile = #{signUpReq.profile} WHERE userIdx = #{userIdx}")
    User updateUser(@Param("userIdx") final int userIdx, @Param("signUpReq") final SignUpReq signUpReq);

    // 회원 탈퇴
    @Delete("DELETE FROM user WHERE userIdx = #{userIdx}")
    void deleteUser(@Param("userIdx") final int userIdx);

}
