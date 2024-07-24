package com.riwi.multimedia.management.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.riwi.multimedia.management.domain.entities.Student;

interface StudentRepository extends JpaRepository<Student, Long> {

    
}