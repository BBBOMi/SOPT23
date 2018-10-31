package org.sopt.review.seminar3.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class User {
    private int userIdx;
    private String name;
    private String part;
}
