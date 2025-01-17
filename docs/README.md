# jwp-shopping-cart

# 📚 도메인 모델 네이밍 사전

| 한글명 | 영문명     | 설명    | 분류    |
|-----|---------|-------|-------|
| 상품  | Product | 상품 정보 | class |

<br>

## DB(DAO)

- H2 데이터베이스를 사용한다.
- DB 테이블 설계
    - Database 명 : `shopping_cart`
        - Table 명 : `product`

          | id | name | image_url | price |
          |----|---------|-------------|-------|
          | 1 | chicken | https://... | 10000 |
          | 2 | pizza | https://... | 12000 |

# 👨‍🍳 기능 목록

## 상품 목록 페이지 연동

- [x] 사용자로부터 `/`에 대해 GET 요청을 받으면 index.html 페이지를 반환한다.
- [x] 상품에 대한 데이터를 담을 클래스를 만든다.
    ```
  GET / HTTP/1.1
  ```

## 관리자 도구 페이지 연동

- [x] 사용자로부터 `/admin`에 대해 GET 요청을 받으면 admin.html 페이지를 반환한다.
    ```
  GET /admin HTTP/1.1
  ```
- [x] 잘못된 요청을 받을 경우 에러처리한다.

### 상품 관리 CRUD API 작성

- [x] 사용자로부터 GET 요청을 받으면 DB에서 상품 목록을 불러와 반환한다.
    ```
  GET /admin HTTP/1.1
  ```
- [x] 사용자로부터 POST 요청을 받으면 새 상품을 DB에 저장한다.
    ```
  POST /admin/products HTTP/1.1
  ```
- [x] 사용자로부터 PUT 요청을 받으면 상품의 정보를 수정하여 DB에 저장한다.
    ```
  PUT /admin/products/{product_id} HTTP/1.1
  ```
- [x] 사용자로부터 DELETE 요청을 받으면 상품을 DB에서 제거한다.
    ```
  DELETE /admin/products/{product_id} HTTP/1.1
  ```

## 테스트 코드 작성

- [x] DAO CRUD 테스트
- [x] 컨트롤러 CRUD 테스트

# 📌 Commit Convention

커밋 메시지는 다음과 같은 형태로 작성합니다.

```Bash
> "커밋의 타입: 커밋 메세지 내용"
ex) "docs: 기능 목록 추가"
```

커밋의 타입은 아래 10가지 중 가장 적절한 것을 선택해 작성합니다.

|  커밋의 타입  |              설명               |
|:--------:|:-----------------------------:|
|   feat   |           새로운 기능 추가           |
|   fix    |             버그 수정             |
|   test   |           테스트 코드 추가           |
|   docs   | 문서를 추가 혹은 수정 (ex. README 수정)  |
|  chore   |   빌드 태스크 업데이트, 패키지 매니저를 설정    |
| refactor |            코드 리팩토링            |
|  style   | 코드 포맷팅, 세미콜론 누락, 코드 변경이 없는 경우 |

- 상세한 컨벤션
  내용은 [Angular JS Git Commit Message Conventions](https://gist.github.com/stephenparish/9941e89d80e2bc58a153)
  를 참고



# 📌 Code Convention

- [우아한 테크코스 Java 코딩 컨벤션](https://github.com/woowacourse/woowacourse-docs/tree/main/styleguide/java)을
  준수합니다.
- IntelliJ의 Formatter를 적용합니다.