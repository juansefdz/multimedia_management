package com.riwi.multimedia.management.api.dto.request;

import java.time.LocalDate;
import java.util.List;

import com.riwi.multimedia.management.domain.entities.ClassEntity;
import com.riwi.multimedia.management.domain.entities.Multimedia;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LessonRequest {

    private Long id;
    private String title;
    private String content;
    private LocalDate createdAt;
    private Boolean isActive;
    private ClassEntity classId;
    private List<Multimedia> multimediaList;
}
