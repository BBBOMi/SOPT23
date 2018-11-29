# 모든 contents 조회 

| 메소드 | 경로                                    | 짧은 설명        |
| ------ | --------------------------------------- | ---------------- |
| GET    | /contents?offset={offset}&limit={limit} | 모든 컨텐츠 조회 |



## QueryString 설명

| parameter | 설명                              | 예시     | 값 범위       |
| --------- | --------------------------------- | -------- | ------------- |
| offset    | 시작 인덱스(기본값 = 0)           | offset=0 | 0 이상의 정수 |
| limit     | 가져올 데이터의 개수(기본값 = 10) | limit=10 | 1이상의 정수  |



## 요청 헤더

```
Content-Type: application/json
```



## 응답 바디

### 모든 글 조회 성공

```
{
    "status": 200,
    "message": "모든 글 조회 성공",
    "data": [
        {
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
    ]
}
```



### ITERNAL SERVER ERROR

```
{
    "status": 500,
    "message": "서버 내부 에러",
    "data": null
}
```