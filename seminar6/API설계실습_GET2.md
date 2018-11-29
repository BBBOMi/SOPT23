# contents 조회 

| 메소드 | 경로                   | 짧은 설명       |
| ------ | ---------------------- | --------------- |
| GET    | /contents/{content_id} | 컨텐츠 상세보기 |



### 요청 헤더

```
Content-Type: application/json
Authorization: token(선택)
```



### 응답 바디

#### 글 조회 성공

```
{
    "status": 200,
    "message": "글 조회 성공",
    "data": {
            "board_id": 11,
            "board_title": "제목",
            "board_content": "내용",
           	"board_date":  "2018-11-29T13:47:35.000+0000",
           	"user_id": 1,
           	"board_like": 0,
           	"board_photo": null,
           	"auth": false,
           	"user_like": false
        }
}
```



#### 없는 글 조회

```
{
    "status": 404,
    "message": "글이 존재하지 않습니다.",
    "data": null
}
```



#### ITERNAL SERVER ERROR

```
{
    "status": 500,
    "message": "서버 내부 에러",
    "data": null
}
```