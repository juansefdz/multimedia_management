package com.riwi.multimedia.management.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.riwi.multimedia.management.domain.entities.Multimedia;

public interface MultimediaRepository extends  JpaRepository<Multimedia, Long> {
    
}
