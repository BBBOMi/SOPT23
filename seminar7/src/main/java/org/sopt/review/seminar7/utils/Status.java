package org.sopt.review.seminar7.utils;

/**
 * Created by bomi on 2018-12-13.
 */

public enum Status {
    OK(200),
    CREATED(201),
    NO_CONTENT(204),
    BAD_REQUEST(400),
    UNAUTHORIZED(401),
    NOT_FOUND(404),
    INTERNAL_SERVER_ERROR(500),
    DB_ERROR(600);

    private int value;

    Status(int value) {
        this.value = value;
    }
}
