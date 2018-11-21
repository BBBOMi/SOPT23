package org.sopt.review.seminar5.mapper;

import org.apache.ibatis.annotations.*;
import org.sopt.review.seminar5.dto.User;
import org.sopt.review.seminar5.model.SignUpReq;

import java.util.List;

/**
 * Created by bomi on 2018-11-13.
 * Modified by bomi on 2018-11-19.
 */

/**
 * @Mapper
 * Spring IoC 컨테이너에 서비스 Bean으로 등록
 * 해당 인터페이스에 등록된 SQL Annotation을 토대로 실제 SQL문을 실행시켜준다
 * 3 이상 버전부터 mapper.xml 대신 interface 클래스의 Annotation을 통해 SQL문을 사용할 수 있음
 * 인터페이스에 선언한다
 */
@Mapper
public interface UserMapper {

    /**
     * @Select : 조회 Annotation
     * #{value}로 동적 바인딩을 처리하고 @Param("value)로 값을 명시한다
     */

    // 모든 회원 리스트 조회
    @Select("SELECT * FROM user")
    List<User> findAll();

    // 회원 이름으로 조회
    @Select("SELECT * FROM user WHERE name = #{name}")
    List<User> findByName(@Param("name") final String name);

    // 회원 고유 번호로 조회
    @Select("SELECT * FROM user WHERE userIdx = #{userIdx}")
    User findByUserIdx(@Param("userIdx") final int userIdx);

    // 이름과 비밀번호로 조회
    @Select("SELECT * FROM user WHERE name = #{name} AND password = #{password}")
    User findByNameAndPassword(@Param("name")final String name, @Param("password")final String password);

    /**
     * @Insert : 데이터 삽입 Annotation
     * 반환 값으로 AI값을 받아오고 싶다면 @Options annotation을 이용해 AI 키 값을 명시해 준다
     * 반환 타입은 int(AI 컬럼 타입과 일치)
     */

    // 회원 등록, Auto-Increment는 회원 고유 번호
    // Auto-Increment 값을 받아오고 싶다면 리턴 타입을 int(Auto-Increment 컬럼 타입)으로 하면 된다
    @Insert("INSERT INTO user(name, part, profileUrl) VALUES(#{signUpReq.name}, #{signUpReq.profileUrl})")
    @Options(useGeneratedKeys = true, keyColumn = "user.userIdx")
    int save(@Param("signUpReq") final SignUpReq signUpReq);

    // Auto-Increment 값을 받아오고 싶지 않다면 @Options가 필요없다
    @Insert("INSERT INTO user(name, part) VALUES(#{user.name}, #{user.part})")
    void save2(@Param("user") final User user);


    /**
     * @Update : 수정 Annotation
     * @Delete : 삭제 Annotation
     */

    // 회원 정보 수정
    @Update("UPDATE user SET name = #{user.name}, part = #{user.part} WHERE userIdx = #{userIdx}")
    void update(@Param("userIdx") final int userIdx, @Param("user") final User user);

    // 회원 삭제
    @Delete("DELETE FROM user WHERE userIdx = #{userIdx}")
    void deleteByUserIdx(@Param("userIdx") final int userIdx);
}
