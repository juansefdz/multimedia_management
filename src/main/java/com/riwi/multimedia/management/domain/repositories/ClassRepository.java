package com.riwi.multimedia.management.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.riwi.multimedia.management.domain.entities.ClassEntity;

public interface ClassRepository extends JpaRepository<ClassEntity, Long> {
    
}
