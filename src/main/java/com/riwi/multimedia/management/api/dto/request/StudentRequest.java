package com.riwi.multimedia.management.api.dto.request;

import java.time.LocalDate;

import com.riwi.multimedia.management.domain.entities.ClassEntity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StudentRequest {

    private Long id;
    private String name;
    private String email;
    private LocalDate createdAt;
    private Boolean isActive;
    private ClassEntity classId;
    
}
