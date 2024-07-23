package com.riwi.multimedia.management.api.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ClassResponse {
    private Long idClass;
    private String nameClass;
    private String description;
    private Boolean isActive;
    private Long idLesson;
    private Long idStudent;
}
