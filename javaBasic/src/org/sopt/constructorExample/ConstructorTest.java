package org.sopt.constructorExample;

public class ConstructorTest {
    public static void main(String[] args) {
        // Instance 생성
        // Default 생성자로 객체 생성
        final User user1 = new User();
        // 매개변수를 통해 객체 생성
        final User user2 = new User(1, "설수연", "Server");

        user1.hello();
        user2.hello();
    }
}
