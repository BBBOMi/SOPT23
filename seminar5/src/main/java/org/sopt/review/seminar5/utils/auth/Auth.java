package org.sopt.review.seminar5.utils.auth;

import java.lang.annotation.*;

/**
 * Created by bomi on 2018-11-21.
 */
// 메소드에 적용
@Target(ElementType.METHOD)
// 런타임시까지 참조 가능
@Retention(RetentionPolicy.RUNTIME)
// Java Doc에도 표시
@Documented
// 상속 가능
@Inherited
public @interface Auth {
}
