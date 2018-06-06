## Spring Boot 강의 by dinfree
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

### H2 Database
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

### Spring Data JPA
* Spring Data JPA 개념
* 컴포넌트 클래스를 만들어 Configuration 클래스에서 jpa dao 를 통해 생성하도록 코딩 해도 됨.
* Spring Data JPA 개념 이해를 위한 SimpleData 예제 작성
	
### Addressbook Project
### JSP 버전
* github clone으로 프로젝트 import 할때 maven project 로 생성함.
* 기존 교재 주소록 프로젝트의 jsp 를 기본적으로 활용함.
* 링크 url 정리 필요.
* JSP 빈즈 사용과 관련된 코드 제거, 기존 컨트롤러 파일 제거 및 컨트롤러 링크 재구성
* 페이지 네비게이션 추가, pageable 이용함.
### Thymeleaf 버전
* jsp 버전을 그대로 활용
* EL 부분과 JSTL 부분을 수정함.
* Javascript 처리 부분은 타임리프에 맞게 변경해야 함. 특히 링크 부분은 jQuery 를 활용하는것이 좋아 보임.		
