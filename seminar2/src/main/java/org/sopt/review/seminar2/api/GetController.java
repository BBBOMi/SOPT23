package org.sopt.review.seminar2.api;

import org.springframework.web.bind.annotation.*;

/**
 * @RestController : REST를 위한 전용 Controller 기능을 부여하는 Annotation
 *
 * @RestController = @Controller + @ResponseBody
 * @Controller : 템플릿을 이용해서 HTML 페이지를 렌더링하고 표시해준다.
 * @ResponseBody : 반환값을 JSON으로 변환해준다.
 */
@RestController
public class GetController {
    /**
     * @GetMapping : Get 메소드 전용 Controller Annotation
     * 리소스를 조회하는 요청에 사용한다
     * 괄호 안에 URL Mapping을 지정
     */
    @GetMapping("")
    public String hello() {
        return "hello world!";
    }

    /**
     * @RequestMapping(method = RequestMethod.GET, value = "") : GET Method이면서 URL Mapping은 ""라는 의미의 Annotation
     * @GetMapping("")과 같은 의미
     * 같은 의미의 Controller Method가 두개 이상 있을 경우 서버 실행 에러 발생
     */
//    @RequestMapping(method = RequestMethod.GET, value = "")
//    public String hello2() {
//        return "Nice to Meet You!";
//    }

    // Get Method이면서 URL Mapping은 1
    @GetMapping("1")
    public String hello2() {
        return "hello world!!";
    }

    // Get Method이면서 URL Mapping은 get1
    @GetMapping("get1")
    public String get1() {
        return "1";
    }

    /* Get Method이면서 URL Mapping은 get1/이름
    *  path의 처음 '/'은 생략이 가능하지만, get1과 이름 사이의 '/'은 생략 불가
    */
    @GetMapping("get1/bomi")
    public String get2() {
        return "My name is Bomi!";
    }

    /**
     * @PathVariable(value = "name") : URL에서 각 구분자에 들어온 값을 처리할 때 사용
     * '/'뒤의 특정 값{}을 name이라는 parameter로 받으라는 의미
     * 이것을 다시 String name으로 변환
     *
     * @PathVariable은 null, 공백 값 허용X
     * Spring에서 @PathVariable를 사용하여 값을 넘겨받을 때 값에 .가 포함되어있으면 .를 포함하여 그 뒤가 잘려서 들어온다는점 주의
     *
     * REST API를 구성하는 중요한 요소
     */
    @GetMapping("name/{name}")
    public String getName(@PathVariable(value = "name") final String name) {
        return name;
    }

    /**
     * @RequestParam : QueryString('/part?part=server'에서 '?part=server'와 같은 문법)을 처리할 때 사용
     * value : queryString의 key값
     * defaultValue : queryString 값이 없을 경우의 기본값
     *
     * 주로 페이지네이션, 검색어 처리 등에 사용
     */
    @GetMapping("part")
    public String getPart(@RequestParam(value = "part", defaultValue = "") final String part) {
        return part;
    }

    /* 여러개의 queryString을 받을 수 있다
        요청 시 queryString key값 사이를 &로 이어주면 된다
     */
    @GetMapping("info")
    public String getPart2(@RequestParam(value = "name") final String name,
                           @RequestParam(value = "type", defaultValue = "YB") final String type) {
        return name + " 이고 " + type + " 입니다";
    }

    /* queryString의 key값을 같게 하면 배열로 받을 수 있다 */
    @GetMapping("num")
    public int number(@RequestParam(value = "num") final int[] num) {
        int sum = 0;
        for(int i : num) {
            sum += i;
        }
        return sum;
    }


}
