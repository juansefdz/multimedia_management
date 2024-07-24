package com.riwi.multimedia.management.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.riwi.multimedia.management.domain.entities.Lesson;

public interface LessonRepository extends JpaRepository<Lesson, Long> {
    
}
