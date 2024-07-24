package com.riwi.multimedia.management.domain.repositories;



import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.riwi.multimedia.management.domain.entities.Student;



@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    @Query("SELECT s FROM Student s WHERE s.isActive = :isActive")
    Page<Student> findAll(@Param ("isActive") boolean isActive, Pageable pageable);


    @Query("SELECT s FROM Student s WHERE s.name LIKE %:name%")
    Page<Student> findAllByName(@Param("name") String name, Pageable pageable);
}