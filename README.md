![image](https://user-images.githubusercontent.com/81465068/219571225-27face3f-67dd-4264-85a6-de09b521e7f5.png)

# 우테코 5기 2레벨 3~4주차 - 장바구니 미션

![Generic badge](https://img.shields.io/badge/level2-week3~4-green.svg)
![Generic badge](https://img.shields.io/badge/version-1.0.1-brightgreen.svg)

> 우아한테크코스 5기 2레벨 3~4주차 미션, 장바구니 미션을 구현한 저장소입니다.

- 상품 목록 페이지
![image](https://github.com/amaran-th/jwp-subway-path/assets/81465068/0666372e-b138-4b29-ad95-9a8132d2312c)
- 관리자 페이지
![image](https://github.com/amaran-th/jwp-subway-path/assets/81465068/20a9e60d-b89c-4f1a-82e0-496bedfffab9)
- 상품 추가 화면
![image](https://github.com/amaran-th/jwp-subway-path/assets/81465068/764899dc-06e1-4b13-b289-f72c4e0dc8d2)
- 설정(사용자 선택) 페이지
![image](https://github.com/amaran-th/jwp-subway-path/assets/81465068/37f0d7cb-b8db-4301-86c9-c638522ce7b2)
- 장바구니 페이지
![image](https://github.com/amaran-th/jwp-subway-path/assets/81465068/953e79c4-9227-4fa6-ab54-6bceca9a2af5)

# 목차
- [시작하기](#시작하기)
- [도메인 모델 네이밍 사전](#도메인-모델-네이밍-사전)
- [DB(DAO)](#dbdao)
- [기능 목록](#기능-목록)
  - [페이지 연동](#페이지-연동)
  - [데이터 추가/수정 삭제 API 구현](데이터-추가-수정-삭제-API-구현)


## 시작하기
해당 레포지토리를 Clone하고 src/main/java/cart에 위치한 JwpCartApplication.java 파일을 실행시켜 프로그램을 동작시킬 수 있습니다.
```
git clone -b as https://github.com/amaran-th/jwp-shopping-cart.git
```

## 도메인 모델 네이밍 사전
| 한글명  | 영문명     | 설명      | 분류    |
|------|---------|---------|-------|
| 상품   | Product | 상품 정보   | class |
| 사용자  | User    | 사용자 정보  | class |
| 장바구니 | Cart    | 장바구니 정보 | class |


## DB(DAO)

- In-Memory DB(H2)를 사용한다.
- DB 테이블 설계
    - Database 명 : `shopping_cart`
        - Table 명 : `product`

          | id | name | image_url | price |
           |----|---------|-------------|-------|
          | 1 | chicken | https://... | 10000 |
          | 2 | pizza | https://... | 12000 |

        - Table 명 : `user`

          | id | email                 | password |
          |----|-----------------------|----------|
          | 1 | songsy405@naver.com   | abcd     | 
          | 2 | songsy405@pusan.ac.kr | 1234     | 

        - Table 명 : `cart`
      
          | id | member_id | product_id |
          |----|-----------------------|----------|
          | 1 | 1 | 3 |
          | 2 | 1 | 2 |


## 기능 목록
### 페이지 연동

- 상품 목록 페이지

  - 사용자로부터 `/`에 대해 GET 요청을 받으면 index.html 페이지를 반환한다.
  - DB에서 상품 목록을 불러와 응답 데이터를 함께불러와 반환한다.

      ```
      GET / HTTP/1.1
      ```


- 관리자 도구 페이지

  - 사용자로부터 `/admin`에 대해 GET 요청을 받으면 admin.html 페이지를 반환한다.

      ```
      GET /admin HTTP/1.1
      ```

  - 잘못된 요청을 받을 경우 에러처리한다.

- 사용자 설정 페이지 연동

  - 사용자로부터 `/settings`에 대해 GET 요청을 받으면 settings.html 페이지를 반환한다.
  - 사용자에 대한 데이터를 담을 클래스를 만든다.

      ```
      GET /settings HTTP/1.1
      ```


- 장바구니 페이지 연동

  - 사용자로부터 `/cart`에 대해 GET 요청을 받으면 cart.html 페이지를 반환한다.
  - 장바구니에 대한 데이터를 담을 클래스를 만든다.

      ```
      GET /cart HTTP/1.1
      ```


### 데이터 추가/수정/삭제 API 구현

1. **상품 관리 CRUD API 작성**

- 사용자로부터 POST 요청을 받으면 새 상품을 DB에 저장한다.
    
    ```
    POST /products HTTP/1.1
    ```
    
    ```java
    {빈 데이터}
    ```
    
- 사용자로부터 PUT 요청을 받으면 상품의 정보를 수정하여 DB에 저장한다.
    
    ```
    PUT /products/{id} HTTP/1.1
    ```
    
    ```java
    {빈 데이터}
    ```
    
- 사용자로부터 DELETE 요청을 받으면 상품을 DB에서 제거한다.
    
    ```
    DELETE /products/{id} HTTP/1.1
    ```
    
    ```java
    {빈 데이터}
    ```
    
    - 만약 cart 테이블에 상품 id가 포함된 데이터가 존재한다면, 해당 데이터를 모두 제거한 뒤 상품 데이터를 제거한다.

2. **장바구니 CRUD API 작성**

- 사용자로부터 인증 정보와 함께 GET 요청을 받으면 DB에서 해당 사용자의 장바구니 목록을 불러와 반환한다.
    
    ```
    GET /cart/products HTTP/1.1
    Authorization: Basic ZW1haWxAZW1haWwuY29tOnBhc3N3b3Jk
    ```
    
    ```java
    [
        {
            "id": 1,
            "name": "피자",
            "price": 13000,
            "imageUrl": "https://searchad-phinf.pstatic.net/MjAyMjEyMjdfMTE1/MDAxNjcyMTAxNTI0Nzg4.WfiSlsy9fTUQJ6q2FTGOaaOVU0QpSB0U1LvplKZQXzIg.H4UgI0VbKUszP7mzC3qhwpSMe15DluJnxjxVGDq_QUgg.PNG/451708-1fa87663-02e3-4303-b8a9-d7eea3676018.png?type=f160_160"
        },
        {
            "id": 2,
            "name": "치킨",
            "price": 27000,
            "imageUrl": "https://search.pstatic.net/common/?src=http%3A%2F%2Fblogfiles.naver.net%2FMjAyMzAzMjdfMTI2%2FMDAxNjc5OTI1ODQ4NTgy.6RT9z-i5prsnwwc-6B9TaK6Q0Zcgsd3TeDGiUdqyDRIg.rW2kMtzBKNFhWWXyr_X2bZfR15AEPUOz-VJnqVaP0jEg.JPEG.koreasinju%2FIMG_3379.jpg&type=ff332_332"
        },
        {
            "id": 4,
            "name": "샐러드",
            "price": 9500,
            "imageUrl": "https://searchad-phinf.pstatic.net/MjAyMzA0MThfMjk0/MDAxNjgxODAwNDY4NjU4.FJcjmoGsxyCq0nZqlcmoAL2mwX8mM9ny9DdliQcqGZ0g.9cGk2IQHfPIm2-ABelEOY1cc-_8NBQgPMgPpjFZkGFEg.JPEG/2814800-bb4236af-96dd-42e7-8256-32ffaa73de52.jpg?type=f160_160"
        }
    ]
    ```
    
- 사용자로부터 인증 정보와 함께 POST 요청을 받으면 새 상품을 DB cart 테이블에 저장한다.
    
    ```
    POST /cart/{product_id} HTTP/1.1
    Authorization: Basic ZW1haWxAZW1haWwuY29tOnBhc3N3b3Jk
    ```
    
    ```
    {추가한 cart 레코드의 id}
    ```
    
    - 이미 존재하는 상품을 추가하려 할 경우 예외처리한다.
- 사용자로부터 인증 정보와 함께 DELETE 요청을 받으면 상품을 DB cart 테이블 에서 제거한다.
    
    ```
    DELETE /cart/{product_id} HTTP/1.1
    Authorization: Basic ZW1haWxAZW1haWwuY29tOnBhc3N3b3Jk
    ```
    
    ```
    {변경된 레코드의 개수}
    ```
    
    - cart에 존재하지 않는 상품을 제거하려 할 경우 예외처리 한다.
- credentials로는 email:password를 base64로 인코딩한 문자열을 사용한다.
