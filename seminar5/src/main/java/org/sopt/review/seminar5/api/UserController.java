package org.sopt.review.seminar5.api;

import lombok.extern.slf4j.Slf4j;

import org.sopt.review.seminar5.model.SignUpReq;
import org.sopt.review.seminar5.service.UserService;

import org.sopt.review.seminar5.utils.auth.Auth;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

import static org.sopt.review.seminar5.model.DefaultRes.FAIL_DEFAULT_RES;

/**
 * Created by bomi on 2018-11-13.
 * Modified by bomi on 2018-11-19.
 */

@Slf4j
@RestController
@RequestMapping("users")
public class UserController {
    private UserService userService;

    public UserController(final UserService userService) {
        this.userService = userService;
    }

    @Auth
    @GetMapping("")
    public ResponseEntity getUser(@RequestParam("name")final Optional<String> name) {
        try {
            // name이 null일 경우 false, null이 아닐 경우 true
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

    /**
     * 회원 가입
     * @param signUpReq
     *      회원 가입 폼
     * @return ResponseEntity
     */
    /*
    * @RequestPart
    * value = "profile" 파일의 키 값은 profile
    * required = false 파일을 필수로 받지 않겠다
    * 아무런 Annotation을 명시하지 않고 객체로 받으면 form-data로 받게된다
    */
    @PostMapping("")
    public ResponseEntity signUp(final SignUpReq signUpReq) {
        try {
            // 파일을 signUpReq에 저장
//            if(profile != null) {
//                // 사진을 같이 전송받았다면 사진을 SignUpReq 객체에 저장
//                signUpReq.setProfile(profile);
//            }
            return new ResponseEntity<>(userService.save(signUpReq), HttpStatus.OK);
        } catch(Exception e) {
            log.error(e.getMessage());
            return new ResponseEntity<>(FAIL_DEFAULT_RES, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * 회원 정보 수정 API
     * 인증 필요
     * @param userIdx
     *      회원 고유 번호
     * @param signUpReq
     *      수정할 회원 정보 객체
     * @return ResponseEntity
     */
    @Auth
    @PutMapping("/{userIdx}")
    public ResponseEntity signUp(@PathVariable(value = "userIdx")final int userIdx,
                                 final SignUpReq signUpReq) {
        try {
//            if(profile != null) {
//                signUpReq.setProfile(profile);
//            }
            return new ResponseEntity<>(userService.update(userIdx, signUpReq), HttpStatus.OK);
        } catch(Exception e) {
            log.error(e.getMessage());
            return new ResponseEntity<>(FAIL_DEFAULT_RES, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * 회원 정보 삭제 API
     * 인증 필요
     * @param userIdx
     *      회원 고유 번호
     * @return  ResponseEntity
     */
    @Auth
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
