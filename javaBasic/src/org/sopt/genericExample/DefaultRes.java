package org.sopt.genericExample;

/**
 * Generic : 클래스 내부에서 사용할 데이터 타입을 외부에서 지정하는 기법
 * 다양한 타입의 객체들을 다루는 메소드나, 컬렉션 클래스에서 컴파일시 타입 체크를 해주는 기능
 * 타입 안정성을 제공
 * 타입체크와 형변환을 생략할 수 있으므로 코드가 간결해짐
 * 컴파일 단계에서 오류를 찾을 수 있다
 * 중복 제거가 가능
 */

// 복수의 제네릭을 사용할 수도 있음
public class DefaultRes <T> {
    private T responseData;

    public DefaultRes(final T responseData) {
        this.responseData = responseData;
    }

}
