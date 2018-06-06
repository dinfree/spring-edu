# Spring Boot 강의 by dinfree
> 본 프로젝트는 Spring framework 기초 및 Spring boot, Spring Data JPA, H2 DB 연동 강좌를 위한 예제 프로젝트 입니다.
> 프로젝트는 계속 업데이트됩니다.

### TODO List
- spring 5.0 및 spring boot 1.5 기반으로 업그레이드 해야 함.
- bootstrap 및 thymleaf 최신 버전으로 수정
- spring security 를 이용한 기본 인증 처리

### 진행현황 : 2018.5.28
- 일부 설정 및 파일 수정

### 진행현황 : 2016.8.28
- Spring Boot 및 MVC 기본 예제 작성
- IT CookBook, 프로젝트로 배우는 자바 웹 프로그래밍 교재의 주소록 프로젝트 -> Spring Boot 버전으로 변환
- pring-data-jpa 버전 DAO, DO 변환
- jsp 기반 컨트롤러 -> Spring MVC Controller 로 변환
- H2 Embedded 데이터베이스 설정 및 초기 데이터 로딩
- 프로젝트 1차 마무리 및 페이지 네비게이션 구현(기존 Thymeleaf 버전을 JSTL 버전으로)

### 목차 
- [1. Demo Project Import](#project-import)
- [2. Demo Project1 - Spring MVC](#demo-spring-mvc)
- [3. Demo Project2 - AddressBook](#demo-addrbook)
- [4. Demo Project3 - Restful Web Service](#demo-restful-web-service)
- [5. Demo Project4 - Spring Data Rest](#demo-spring-data-rest)
- [6. H2 Database 설정](#h2-database)

--------------------------
## Demo Project
### Project Import
* IntelliJ 를 사용함.
* IntelliJ 플러그인 설정에서 spring boot, data, aop, mvc 등이 선택되어 있는지 확인.
* github clone으로 프로젝트 import 하는 과정에서 maven project 로 생성 선택.
* PC에 git이 설치되어 있지 않은 경우 에러 메시지 확인하고 다운로드 및 설치후 다시 시작.
* 프로젝트 생성 및 maven dependency library 들을 다운로드 할때 까지 대기.
* 프로젝트 선택후 Ctrl+Enter 로 Project Structure 화면 진입.
* SDK 선택이 안되어 있는 경우 확인해서 선택하거나 New 르 이용해 설치되 경로 지정.(JDK 1.8 이상)
* Modules -> Spring -> + 를 이용해 unmapped module 추가
* DemoApplication 을 선택후 실행
* 포트 충돌나는 경우 오라클등을 중지 하거나 application.properties 파일에 다음으 추가
```
server.port=9090
```
* http://localhost:9090/addrbook/  접속해서 동작 확인
* 최초 실행후 application.properties 에 다음과 같이 false 설정 
```
spring.datasource.initialize=false
```

### DEMO Spring MVC
기본적인 spring mvc 컨트롤러의 동작을 정의하고 확인해봄. 먼저 다음과 같이 동작 테스트.
```
http://localhost:9090/hello
http://localhost:9090/hello?name=YourName
```
controller 패키지의 HelloCtl 클래스 소스는 다음과 같음.
```java
@Controller
public class HelloCtl {
	@GetMapping("/hello")
	public String hello(@RequestParam(value="name", required=false, defaultValue="HITLAB") String name, Model model){
        model.addAttribute("name", name);
        return "hello";
	}
}
```
- @Controller: 컨트롤러 클래스로 설정함.
- @GetMapping("/hello"): 지정된 경로에 대한 GET 요청시 실행되는 메서드로 지정.
- @RequestParam: 클라이언트로 부터 전달되는 Request 파라미터를 처리할때 사용. 만일 전달되는 데이터가 많은 경우 Entity 클래스를 정의하고 해당 Entty 클래스를 메서드의 파라미터로 지정하면 됨.
- model.addAttribute(): 뷰로 데이터르 전달하기 위해 모델 객체에 데이터를 저장함.
- return "hello": 리턴되는 문자열은 뷰(여기서는 JSP)의 이름이 됨. 확장자는 쓰지 않고 JSP 경로는 다음과 같이 application.properties 에 지정되어 있음.
```
# View Setting
spring.mvc.view.prefix=/WEB-INF/jsp/
spring.mvc.view.suffix=.jsp
```

### Demo Addrbook
Spring MVC, Spring Data JPA, H2 datbase 기반으로 기존 주소록 소스로 구성됨.
소스리뷰는 configuration 클래스, entity, dao 클래스, 컨트롤러 순으로 살펴봄.
#### WebConfiguration
- @Configuration: 스프링 설정 클래스로 지정. MVC 설정, Security 설정등 설정 어댑터 클래스들이 존재 하며 스프링부트에서는 이들 클래스르 상속받는 커스텀 설정 클래스를 만들게 됨.
- @Bean: 스프링 빈 객체 생성을 위한 애너테이션. 메서드의 리턴타입의 객체가 스프링빈 객체로 생성되어 컨테이너에 등록됨을 의미함.

#### AddrBook
엔티티 클래스로 데이터베이스 테이블 구조와 매핑될 수 있도록 멤버필드를 구성하고 getter/setter 메서드를 만들면 됨. lombok 을 이용하면 getter/setter 생략 가능함.
- @Entity: 데이터를 표현하기 위해 entity 객체임을 알림
- @Id: 프라이머리키와 매핑될 멤버필드
- @GeneratedValue: 자동생성된 값으로 관리되기를 원하는 경우

#### AddrBookDAO
DAO 클래스로 Spring Data JPA 를 사용해 H2 데이터베이스와 연동하는 클래스. 기본적으로 인터페이스만 생성하면 모든 DAO클래스의 메서드는 자동 구성됨. 이경우 제한된 범위에서 기본제공 메서드르 이용해 데이터의 CRUD 기능 사용이 가능하며 몇몇 검색기능도 사용하 수 있음. 만일 복잡한 처리를 해야 한다면 @Query 를 이용해 별도의 검색쿼리를 일부 이용하거나 인터페이스 클래스를 상속해 구현클래스를 만들어 필요한 메서드를 직접 구현하면된다. 그 외 서비스클래스를 정의하거나 컨트롤러에서도 JDBC템플릿등을 만들어 일부 처리할 수 있다. 여기서는 페이지 설정을 위해 수정되는 findAll() 메서드만 별도 정의 하였다.
- @Repository: 리파지토리(DAO) 클래스임을 알림. 여기서는 JpaRepository 를 상속받는 것으로 함.

#### AddrBookController
컨트롤러 클래스로 HelloCtl 과 동일함. 추가되는 내용만 살펴보면,
- @Autowired: 스프링빈 객체를 매핑하기 위한 애너테이션. 여기서는 AddrBookDAO 타입을 abdao 로 매핑하겠다는 것임. AddrBookDAO 인터페이스 타입은 @Repository 애너테이션으로 이미 자동 생성되어 있음.
- @PathVariable: url 경로형태 전달되는 변수값을 받아오기 위한 애너테이션.
- @PostMapping: HTTP Post 요청(예를들명 form submit)을 처리하기 위한 애너테이션

### Demo Restful web service
스프링에서 Restful 웹서비스를 구현하기 위한 방법을 알아 본다. simpledata 패키지의 소스를 보도로 한다.

#### Entity Class
- SimpleData 및 SimpleDataDAO 인터페이스, 내용은 앞에서와 동일함. DAO의 경우 별도 메서드 정의 없이 제공되는 메서드만 사용.

#### Rest Controller
- SimpleDBRestCtl 클래스
- @RestController: Restful 서비스를 제공하기 위한 컨트롤러 클래스임을 선언.

#### 동작 테스트
웹브라우저 혹은 Postman(권장), 내장 HTTP Client(Deprecated 됨. 에디터기반으로 변경) 등을 이용해 테스트 가능함. 컨트롤러에 정의된 url 기반으로 테스트.

### Demo Spring Data Rest
Spring Data Rest 는 자동으로 데이터베이스와의 인터페이스를 HAL 을 지원하도록 컨트롤러와 리파지토리 설정을 자동으로 함께 해준다.
먼저 pom.xml 에 다음이 추가 되어야 한다. 추가된 이후에는 프로젝트내 모든 데이터베이스 연결에 영향을 미친다. 필요한 경우 HAL Browser 도 함께 등록해 준다.

```
<dependency>
	<groupId>org.springframework.boot</groupId>
	<artifactId>spring-boot-starter-data-rest</artifactId>
</dependency>
```
- http://localhost:9090 으로 접속하면 접속가능한 리스트가 나옴.
- profile 로 각 서비스별 제공 가능한 기능 확인.
- page, size 파라미터르 통해 페이지 단위로 조회 가능함.
- api_test.http 를 이용해 테스트

## H2 Database
* H2 데이터베이스는 스프링에서 기본적으로 사용할 수 있는 내장형 DB로 메모리, 파일, 서버 형태 모두 운영이 가능함.
* 콘솔 접속 : http://localhost:8080/console
* console 접속시 jdbc url 을 jdbc:h2:mem:testdb 와 같이 설정 함. 
* file base 의 경우 jdbc:h2:file:~/testdb 같이 경로 설정을 해주어야 함.
* 초기 스키마 생성이 필요할 경우 resource/schema.sql 에 create table 작성. 단, 이경우에는 spring.jpa.hibernate.ddl-auto=none 속성 추가필요.
* 초기 데이터는 resource/data.sql 을 작성하면됨.
```
application.properties
# initialize=true 인경우 data.sql 로드, false 는 읽지 않음.
spring.datasource.initialize=true
spring.jpa.hibernate.ddl-auto=none

# Datasource , 경로부분은 운영체제 경로임. db file 생성됨.
spring.datasource.url=jdbc:h2:file:~/testdb
spring.datasource.username=sa
spring.datasource.password=
spring.datasource.driver-class-name=org.h2.Driver
```
