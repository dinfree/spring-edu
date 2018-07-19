package com.dinfree.spring.edu.simpledata;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SimpleDataDAO extends JpaRepository<SimpleData, Integer> {
    
}
