package org.sopt.review.seminar2.api;

import org.sopt.review.seminar2.model.User;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("put")
public class PutController {

    /**
     * @PutMapping : Put method 전용 Controller Annotation
     * 리소스를 수정하는 요청에 사용
     */
    @PutMapping("")
    public String putUser(@RequestBody final User user) {
        return user.getPart();
    }
}
