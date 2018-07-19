package com.dinfree.spring.edu.addrbook;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 * File : AddrBook.java
 * Desc : Spring boot 기반 주소록 프로그램 DO 클래스
 * @author 황희정(dinfree@dinfree.com)
 */
// 기본 테이블은 클래스 이름이 CamelCase 인 경우 Addr_Book 으로 생성됨. 변경하려면 정책설정 수정 혹은 첫글자만 대문자 혹은 name 지정. 필드명도 마찬가지임.
@Entity
public class AddrBook {
    // 멤버변수 선언
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull
    @Size(min = 3, max = 5)
    private String name;

    @Email
    private String email;

    @Pattern(regexp = "/^\\d{3}-\\d{3,4}-\\d{4}$/")
    private String tel;

    @Pattern(regexp = "/^(19|20)\\d{2}-(0[1-9]|1[012])-(0[1-9]|[12][0-9]|3[0-1])$/")
    private String birth;

    private String comdept;
    private String memo;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getBirth() {
        return birth;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }

    public String getComdept() {
        return comdept;
    }

    public void setComdept(String comdept) {
        this.comdept = comdept;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }
}
