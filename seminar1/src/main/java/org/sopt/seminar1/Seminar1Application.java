package org.sopt.seminar1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @SpringBootApplication = @Configuration + @EnableAutoConfiguration + @ComponentScan
 * @Configuration : 현재 클래스가 스프링의 설정 파일임을 Spring Context에게 알려주는 Annotation
 * @EnableAutoConfiguration : Spring boot가 설정을 자동으로 하도록 하는 Annotation
 * @ComponentScan : 다른 컴포넌트, 서비스, 설정 드을 찾을 수 있게 도와주는 Annotation
 */
@SpringBootApplication
public class Seminar1Application {

    public static void main(String[] args) {
        SpringApplication.run(Seminar1Application.class, args);
    }
}
