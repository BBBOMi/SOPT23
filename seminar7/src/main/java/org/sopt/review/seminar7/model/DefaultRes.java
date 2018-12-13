package org.sopt.review.seminar7.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.sopt.review.seminar7.utils.Message;
import org.sopt.review.seminar7.utils.Status;

/**
 * Created by bomi on 2018-12-13.
 */

@Data
@AllArgsConstructor
@Builder
public class DefaultRes<T> {
    private Status status;
    private Message message;
    private T data;

    public DefaultRes(final Status status,final Message message) {
        this.status = status;
        this.message = message;
        this.data = null;
    }

    public static <T> DefaultRes<T> res(final Status status, final Message message) {
        return res(status, message, null);
    }

    public static <T> DefaultRes<T> res(final Status status, final Message message, final T data) {
        return DefaultRes.<T>builder()
                .data(data)
                .message(message)
                .status(status)
                .build();
    }

    public static final DefaultRes FAIL_DEFAULT_RES =
            new DefaultRes(Status.INTERNAL_SERVER_ERROR, Message.INTERNAL_SERVER_ERROR);
}
