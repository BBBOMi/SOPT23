package org.sopt.constructorExample;

public class User {
    // Field = 속성 = 상태 = 멤버 변수
    // 접근 제어 지시자는 private
    // Field는 JVM 내의 Method(Static) Area에 할당

    private int idx; // 회원 고유번호
    private String name; // 이름
    private String part; // 파트

    // Constructor : Instance를 생성해주는 특수한 메소드
    // 생성자의 이름은 클래스 이름과 동일
    // 접근 제어 지시자는 반드시 public

    /**
     * 회원 객체 생성자
     * Default 생성자
     * 매개변수가 없는 생성자
     */
    public User() {
        this.idx = 2;
        this.name = "김보미";
        this.part = "Server";
    }

    /**
     * 회원 객체 생성자
     * 매개변수가 있는 생성자
     *
     * @param idx  회원 고유 번호
     * @param name 이름
     * @param part 파트
     */
    public User(final int idx, final String name, final String part) {
        this.idx = idx;
        this.name = name;
        this.part = part;
    }

    // 은닉화
    // 클래스의 field는 private로 접근 제어지시자로 지정한 뒤
    // getter, setter를 통해 field의 값을 호출, 변경

    public int getIdx() {
        return idx;
    }

    public void setIdx(int idx) {
        this.idx = idx;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPart() {
        return part;
    }

    public void setPart(String part) {
        this.part = part;
    }

    // Method : 객체의 동작,// Instance 생성
    //        // Default 생성자로 객체 생성
    //        final User user1 = new User();
    //        // 매개변수를 통해 객체 생성
    //        final User user2 = new User(1, "설수연", "Server");
    //
    //        user1.hello();
    //        user2.hello(); 행위, 기능
    // Method는 JVM 내의 Method(Static) Area에 할당된다

    // 인사 메소드
    public void hello() {
        System.out.println("안녕하세요. 저는 " + part + "파트 " + name + "입니다");
    }
}
