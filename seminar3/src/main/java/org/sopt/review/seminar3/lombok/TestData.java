package org.sopt.review.seminar3.lombok;

/**
 * Created by bomi on 2018-10-29.
 */

import lombok.Data;

/**
 * @Data
 * 모든 메소드 자동 생성
 * @Setter
 * @Getter
 * @ToString
 * @EqualsAndHashCode
 * @NoArgsConstructor
 */

@Data
public class TestData {
    private int userIdx;
    private String name;
    private String email;
}
