package com.sts.ProductList.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sts.ProductList.entity.Student;

@Repository
public interface StudentRepo extends JpaRepository<Student, Integer> {

}
