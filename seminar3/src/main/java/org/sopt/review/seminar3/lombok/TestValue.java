package org.sopt.review.seminar3.lombok;

/**
 * Created by bomi on 2018-10-29.
 */

import lombok.AccessLevel;
import lombok.Value;
import lombok.experimental.NonFinal;
import lombok.experimental.Wither;

/**
 * @Value
 * immutable class를 만드는 Annotation
 * 모든 필드를 private final
 * Getter 메소드만 자동생성(Setter 메소드는 생성하지 않는다)
 * Final class = 더 이상의 상속 불가능
 * AllArgsConstructor 자동 생성
 * import org.springframework.beans.factory.annotation.value; 와 다르다!!
 *
 * @Wither
 * 값을 변경한 새로운 객체를 만들어준다
 *
 * @NonFinal
 * 필드의 final을 선언하지 않을 때 사용
 * 해당 필드의 final이 해제 된다
 */

@Value
public class TestValue {
    @Wither(AccessLevel.PROTECTED)
    private int userIdx;
    @NonFinal
    private String name;
    private String email;
}
