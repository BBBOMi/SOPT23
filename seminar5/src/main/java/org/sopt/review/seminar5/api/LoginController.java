package org.sopt.review.seminar5.api;

import ch.qos.logback.core.pattern.util.RegularEscapeUtil;
import lombok.extern.slf4j.Slf4j;
import org.sopt.review.seminar5.model.DefaultRes;
import org.sopt.review.seminar5.model.LoginReq;
import org.sopt.review.seminar5.service.AuthService;
import org.sopt.review.seminar5.utils.ResponseMessage;
import org.sopt.review.seminar5.utils.StatusCode;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by bomi on 2018-11-21.
 */

@Slf4j
@RestController
public class LoginController {
    private static final DefaultRes FAIL_DEFAULT_RES = new DefaultRes(StatusCode.INTERNAL_SERVER_ERROR, ResponseMessage.INTERNAL_SERVER_ERROR);
    private final AuthService authService;

    public LoginController(final AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("login")
    public ResponseEntity login(@RequestBody final LoginReq loginReq) {
        try {
            return new ResponseEntity(authService.login(loginReq), HttpStatus.OK);
        } catch(Exception e) {
            log.error(e.getMessage());
            return new ResponseEntity(FAIL_DEFAULT_RES, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
