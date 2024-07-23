package com.riwi.multimedia.management.api.dto.response;

import java.time.LocalDate;

import com.riwi.multimedia.management.domain.entities.Lesson;
import com.riwi.multimedia.management.util.enums.MultimediaType;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MultimediaResponse {    
   
    private Long id;
    private MultimediaType type;
    private String url;
    private LocalDate createdAt;
    private Boolean isActive;
    private Lesson lessonId;
    
}
