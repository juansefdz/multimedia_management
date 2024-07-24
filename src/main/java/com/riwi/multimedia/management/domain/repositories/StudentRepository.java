package com.riwi.multimedia.management.domain.repositories;



import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.riwi.multimedia.management.domain.entities.Student;



@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    Page<Student> findAllByIsActive(boolean isActive, Pageable pageable);
    Page<Student> findAllByNameAndIsActive(String name, boolean isActive, Pageable pageable);
}