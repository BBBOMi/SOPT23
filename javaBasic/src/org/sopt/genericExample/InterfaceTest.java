package org.sopt.genericExample;

import org.sopt.constructorExample.User;

public class InterfaceTest {
    public static void main(String[] args) {
        // generic 사용의 예
        final User user1 = new User();
        DefaultRes<User> defaultRes1 = new DefaultRes<>(user1);
    }
}
