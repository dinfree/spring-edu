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

### 강의진행 목차 
- [1. Spring Basic](#spring-basic)
- [2. Spring Boot with JSP](#spring-boot-with-jsp)
- [3. Spring Data JPA](#spring-data-jpa)
- [4. Addressbook Project](#addressbook-project)

--------------------------
## Demo Project
### import 방법
* IntelliJ 를 사용함.
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

### Demo 프로젝트: Spring MVC, Spring Data JPA, H2 - Addrbook

### Demo 프로젝트: Restful web service

### Demo 프로젝트: Spring Data Rest with HAL Browser

## Spring Study
### Spring Basic
* spring-initializer 를 이용한 스프링 프로젝트 셋팅
* Eclipse IDE 에서 프로젝트 생성 with pom.xml
* 디렉토리 구조 설정
* 주요 애너테이션
- @Component, @Bean, @Autowired
- @Configuration
- @Controller, @RequestMapping, @RestController, @ResponseBody
		 
### Spring Boot with JSP
* Spring MVC 기본 개념
* Spring Boot 개념
* JSP 뷰 사용을 위한 프로퍼티 설정
* JSP 뷰 동작 HelloWorld 예제 작성
* Test 코드 작성 - 모델 데이터 점검, 스프링 객체 점검, Rest api 점검, 뷰 리졸버 점검
* static css 파일은 resource/static/css 아래에 두고 "/css/**.css"로 사용함.
* view jsp 에서 다른 jsp 를 include 할때 /WEB-INF/jsp/xxx/xxx.jsp 형태로 접근해야 함. 

## H2 Database
* H2 데이터베이스 소개 및 셋팅
* 콘솔 접속 : http://localhost:8080/console
* console 접속시 jdbc url 을 jdbc:h2:mem:testdb 와 같이 설정 함. 
* file base 의 경우 jdbc:h2:file:~/testdb 같이 경로 설정을 해주어야 함.
* 초기 스키마 생성이 필요할 경우 resource/schema.sql 에 create table 작성. 단, 이경우에는 spring.jpa.hibernate.ddl-auto=none 속성 추가필요.
* 초기 데이터는 resource/data.sql 을 작성하면됨.
```
# initialize=true 인경우 data.sql 로드, false 는 읽지 않음.
spring.datasource.initialize=true
spring.jpa.hibernate.ddl-auto=none

# Datasource , 경로부분은 운영체제 경로임. db file 생성됨.
spring.datasource.url=jdbc:h2:file:~/testdb
spring.datasource.username=sa
spring.datasource.password=
spring.datasource.driver-class-name=org.h2.Driver
```

## Spring Data JPA
* Spring Data JPA 개념
* 컴포넌트 클래스를 만들어 Configuration 클래스에서 jpa dao 를 통해 생성하도록 코딩 해도 됨.
* Spring Data JPA 개념 이해를 위한 SimpleData 예제 작성
