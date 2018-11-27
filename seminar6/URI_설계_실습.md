# URI

## contents

| 메소드 | 경로                  | 설명               |
| ------ | --------------------- | ------------------ |
| GET    | /contents/            | 모든 컨텐츠 리스트 보기 |
| GET    | /contents/{content_id} | 컨텐츠 상세보기    |
| GET | /users/{user_id}/contents?offset={page_no}&limit={page_size} | 작성자 id로 컨텐츠 목록 조회 |
| POST | /contents/ | 컨텐츠 등록 |
| PUT | /contents/{content_id} | 컨텐츠 수정 |
| DELETE | /contents/{content_id} | 컨텐츠 삭제 |



## Following

| 메소드 | 경로                                                         | 설명                         |
| ------ | ------------------------------------------------------------ | ---------------------------- |
| GET    | /users/{user_id}/following/count                             | 내가 팔로우 한 수 조회       |
| GET    | /users/{user_id}/following?offset={page_no}&limit={page_size} | 내가 팔로우한 사람 명단 조회 |
| POST   | /users/{user_id}/following/{follow_id}                       | 팔로우                       |
| DELETE | /users/{user_id}/following/{follow_id}                       | 팔로우 취소                  |



## Followers

| 메소드 | 경로                                                         | 설명           |
| ------ | ------------------------------------------------------------ | -------------- |
| GET    | /users/{user_id}/followers?offset={page_no}&limit={page_size} | 팔로워 조회    |
| GET    | /users/{user_id}/followers/count                             | 팔로워 수 조회 |



### 후에 로그인(Auth)기능을 추가한다면

## Following

| 메소드 | 경로                                                         | 설명                         |
| ------ | ------------------------------------------------------------ | ---------------------------- |
| GET    | /토큰을 통해 유추/following/count                            | 내가 팔로우 한 수 조회       |
| GET    | /토큰을 통해 유추/following?offset={page_no}&limit={page_size} | 내가 팔로우한 사람 명단 조회 |
| POST   | /토큰을 통해 유추/following/{follow_id}                      | 팔로우                       |
| DELETE | /토큰을 통해 유추/following/{follow_id}                      | 팔로우 취소                  |



## Followers

| 메소드 | 경로                                                         | 설명           |
| ------ | ------------------------------------------------------------ | -------------- |
| GET    | /토큰을 통해 유추//followers?offset={page_no}&limit={page_size} | 팔로워 조회    |
| GET    | /토큰을 통해 유추/followers/count                            | 팔로워 수 조회 |
