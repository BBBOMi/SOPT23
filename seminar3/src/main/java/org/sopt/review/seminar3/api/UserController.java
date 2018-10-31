package org.sopt.review.seminar3.api;

import lombok.extern.slf4j.Slf4j;
import org.sopt.review.seminar3.model.DefaultRes;
import org.sopt.review.seminar3.model.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// 로그 출력 annotation
@Slf4j
@RestController
@RequestMapping("/users")
public class UserController {

    @GetMapping("")
    public ResponseEntity getAllUsers() {
        log.info("get All Users");
        User user = new User(1, "김보미", "서버");
        DefaultRes<User> defaultRes = new DefaultRes(HttpStatus.OK.value(), "Success Find User", user);
        return new ResponseEntity<>(defaultRes, HttpStatus.OK);
    }
}
