package com.riwi.multimedia.management.api.dto.response;

import java.time.LocalDate;
import com.riwi.multimedia.management.domain.entities.ClassEntity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StudentResponse {
    private Long id;
    private String name;
    private String email;
    private LocalDate createdAt;
    private Boolean isActive;
    private ClassEntity classId;    



    
}
