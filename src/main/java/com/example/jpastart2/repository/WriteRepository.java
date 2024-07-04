package com.example.jpastart2.repository;

import com.example.jpastart2.entity.User;
import com.example.jpastart2.entity.Write;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WriteRepository extends JpaRepository<Write,Long> {
    List<Write> findByWriter(Write write);
}
