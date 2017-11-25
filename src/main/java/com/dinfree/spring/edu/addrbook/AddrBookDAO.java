package com.dinfree.spring.edu.addrbook;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Spring boot 기반 주소록 프로그램
 * Spring-data-jpa 를 사용해서 DAO 클래스의 구현부는 따로 구현하지 않음.
 * @author dinfree
 *
 */
@Repository
public interface AddrBookDAO extends JpaRepository<AddrBook, Integer> {
    Page<AddrBook> findAll(Pageable pageable);
}
