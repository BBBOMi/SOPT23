package org.sopt.review.seminar7.dto;

import lombok.Data;

/**
 * Created by bomi on 2018-12-14.
 */

@Data
public class User {
    private int userIdx;
    private String name;
    private String email;
    private String profileUrl;
}
