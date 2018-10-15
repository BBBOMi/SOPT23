package org.sopt.review.seminar2.api;

import org.sopt.review.seminar2.model.User;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("delete")
public class DeleteController {

    /**
     * @DeleteMapping : Delete Method 전용 Controller Annotation
     * 리소스를 삭제하는 요청에 사용
     */
    @DeleteMapping("")
    public String deleteUser(@RequestBody final User user) {
        return "delete Success";
    }
}
