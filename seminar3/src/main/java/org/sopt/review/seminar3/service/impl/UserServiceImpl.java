package org.sopt.review.seminar3.service.impl;

import org.sopt.review.seminar3.model.DefaultRes;
import org.sopt.review.seminar3.model.User;
import org.sopt.review.seminar3.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by bomi on 2018-10-31.
 */

@Service
public class UserServiceImpl implements UserService {

    private static List<User> userList = new LinkedList<>();

    @Override
    public DefaultRes<List<User>> findAll() {
        if(userList.isEmpty()) {
            return DefaultRes.res(HttpStatus.NOT_FOUND.value(), "리스트가 비었습니다.");
        }
        return DefaultRes.res(HttpStatus.OK.value(), "리스트 조회 성공!", userList);
    }

    @Override
    public DefaultRes<User> findByUserIdx(int userIdx) {
        Iterator<User> it = userList.iterator();
        while(it.hasNext()) {
            User user = it.next();
            if(user.getUserIdx() == userIdx) {
                return DefaultRes.res(HttpStatus.OK.value(), "회원 찾기 성공!", user);
            }
        }
        return DefaultRes.res(HttpStatus.NOT_FOUND.value(), "해당 인덱스의 회원이 없습니다.");
    }

    @Override
    public DefaultRes save(User user) {
        userList.add(user);
        return DefaultRes.res(HttpStatus.OK.value(), "회원 저장 성공!");
    }

    @Override
    public DefaultRes<User> update(int userIdx, User user) {
        Iterator<User> it = userList.iterator();
        while(it.hasNext()) {
            User u = it.next();
            if(u.getUserIdx() == userIdx) {
                userList.set(userList.indexOf(u), user);
                return DefaultRes.res(HttpStatus.OK.value(), "회원 정보 수정 성공!");
            }
        }
        return DefaultRes.res(HttpStatus.NOT_FOUND.value(), "일치하는 ID의 회원이 없습니다.");
    }

    @Override
    public DefaultRes deleteByUserIdx(int userIdx) {
        Iterator<User> it = userList.iterator();
        while(it.hasNext()) {
            User user = it.next();
            if(user.getUserIdx() == userIdx) {
                userList.remove(user);
                return DefaultRes.res(HttpStatus.OK.value(), "회원 삭제 성공!");
            }
        }
        return DefaultRes.res(HttpStatus.NOT_FOUND.value(), "일치하는 ID의 회원이 없습니다. ");
    }
}
