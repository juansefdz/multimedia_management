package com.riwi.multimedia.management.api.dto.request;


import java.util.List;

import com.riwi.multimedia.management.api.dto.request.update.ClassRequestUpdate;
import com.riwi.multimedia.management.domain.entities.Lesson;
import com.riwi.multimedia.management.domain.entities.Student;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ClassRequest extends ClassRequestUpdate{

    private Long idClass;
    private Boolean isActive;
    private List<Lesson> lessons;
    private List<Student> students;

    
}
