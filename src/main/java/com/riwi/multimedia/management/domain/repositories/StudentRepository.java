package com.riwi.multimedia.management.domain.repositories;



import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.riwi.multimedia.management.domain.entities.Student;



@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    @Query("SELECT s FROM Student s WHERE s.active = :isActive")
    Page<Student> findAllByisActive(boolean isActive, Pageable pageable);
}