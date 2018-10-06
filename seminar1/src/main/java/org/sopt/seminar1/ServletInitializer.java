package org.sopt.seminar1;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * 1. Packaging을 War로 설정할 시 자동 생성되는 클래스(Jar로 설정할 시엔 생성 X)
 * 2. WebApplicationInitializer Interface의 구현체
 * 3. Tomcat 같은 Servlet Container 환경에서 Spring Boot Application이 동작 될 수 있도록 하는
        Web Application Context를 구성한다는 의미
 */
public class ServletInitializer extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(Seminar1Application.class);
    }

}
