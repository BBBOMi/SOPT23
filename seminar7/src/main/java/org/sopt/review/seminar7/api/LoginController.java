package org.sopt.review.seminar7.api;

import lombok.extern.slf4j.Slf4j;
import org.sopt.review.seminar7.model.DefaultRes;
import org.sopt.review.seminar7.utils.Message;
import org.sopt.review.seminar7.utils.Status;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by bomi on 2018-12-13.
 */

@Slf4j
@RestController
public class LoginController {
    @PostMapping("login")
    public ResponseEntity login() {

        return new ResponseEntity(DefaultRes.res(Status.OK, Message.SUCCEED_LOGIN), HttpStatus.OK);
    }
}
