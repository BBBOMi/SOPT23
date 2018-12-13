package org.sopt.review.seminar7.api;

import lombok.extern.slf4j.Slf4j;
import org.sopt.review.seminar7.model.DefaultRes;
import org.sopt.review.seminar7.utils.Message;
import org.sopt.review.seminar7.utils.Status;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Created by bomi on 2018-12-13.
 */

@Slf4j
@RestController
@RequestMapping("users")
public class UserController {
    @GetMapping("{userIdx}")
    public ResponseEntity getUsers(@PathVariable(name = "userIdx")int userIdx) {


        return new ResponseEntity(DefaultRes.res(Status.OK, Message.SUCCEED_GET_USER), HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity signUp() {



        return new ResponseEntity(DefaultRes.res(Status.OK, Message.CREATE_USER), HttpStatus.OK);
    }

    @PutMapping("{userIdx}")
    public ResponseEntity updateUser(@PathVariable(name = "userIdx")int userIdx) {


        return new ResponseEntity(DefaultRes.res(Status.OK, Message.SUCCEED_UPDATE), HttpStatus.OK);
    }

    @DeleteMapping("{userIdx}")
    public ResponseEntity deleteUser(@PathVariable(name = "userIdx")int userIdx) {


        return new ResponseEntity(DefaultRes.res(Status.OK, Message.DELETE_USER), HttpStatus.OK);
    }
}
