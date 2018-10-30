package org.sopt.review.seminar3.lombok;

/**
 * Created by bomi on 2018-10-29.
 */

import lombok.AllArgsConstructor;
import lombok.NonNull;

/**
 * @NonNull
 * Runtime시에 Null 체크를 통해 NullPointerException 발생
 * 클래스가 아닌 필드에 붙는 annotation
 * compile시에는 null 체크하지 않는다
 */

@AllArgsConstructor
public class TestNonNull {
    private int userIdx;
    // runtime시에 name필드를 null 체크 하겠다는 의미
    @NonNull
    private String name;
    private String email;

    // compile시에 null은 체크하지 않는다
    public TestNonNull() {
        this.name = null;
    }
}
