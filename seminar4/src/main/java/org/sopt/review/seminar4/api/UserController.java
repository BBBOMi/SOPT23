package org.sopt.review.seminar4.api;

import lombok.extern.slf4j.Slf4j;
import org.sopt.review.seminar4.dto.User;
import org.sopt.review.seminar4.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

import static org.sopt.review.seminar4.model.DefaultRes.FAIL_DEFAULT_RES;

/**
 * Created by bomi on 2018-11-13.
 */

@Slf4j
@RestController
@RequestMapping("users")
public class UserController {
    private UserService userService;

    public UserController(final UserService userService) {
        this.userService = userService;
    }

    @GetMapping("")
    public ResponseEntity getUser(@RequestParam("name")final Optional<String> name) {
        try {
            if(name.isPresent()) {
                return new ResponseEntity<>(userService.findByName(name.get()), HttpStatus.OK);
            } else {
                return new ResponseEntity<>(userService.getAllUsers(), HttpStatus.OK);
            }
        } catch(Exception e) {
            log.error(e.getMessage());
            return new ResponseEntity<>(FAIL_DEFAULT_RES, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("")
    public ResponseEntity signUp(@RequestBody final User user) {
        try {
            return new ResponseEntity<>(userService.save(user), HttpStatus.OK);
        } catch(Exception e) {
            log.error(e.getMessage());
            return new ResponseEntity<>(FAIL_DEFAULT_RES, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{userIdx}")
    public ResponseEntity signUp(@PathVariable(value = "userIdx")final int userIdx, @RequestBody final User user) {
        try {
            return new ResponseEntity<>(userService.update(userIdx, user), HttpStatus.OK);
        } catch(Exception e) {
            log.error(e.getMessage());
            return new ResponseEntity<>(FAIL_DEFAULT_RES, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{userIdx}")
    public ResponseEntity deleteUser(@PathVariable(value = "userIdx")final int userIdx) {
        try {
            return new ResponseEntity<>(userService.deleteByUserIdx(userIdx), HttpStatus.OK);
        } catch(Exception e) {
            log.error(e.getMessage());
            return new ResponseEntity<>(FAIL_DEFAULT_RES, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
