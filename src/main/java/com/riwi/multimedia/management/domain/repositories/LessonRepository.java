package com.riwi.multimedia.management.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.riwi.multimedia.management.domain.entities.Lesson;

@Repository
public interface LessonRepository extends JpaRepository<Lesson, Long> {
    
}
