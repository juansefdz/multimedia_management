package com.riwi.multimedia.management.infrastructure.mappers;


import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import java.util.List;

import com.riwi.multimedia.management.api.dto.request.LessonRequest;
import com.riwi.multimedia.management.api.dto.response.LessonResponse;
import com.riwi.multimedia.management.domain.entities.Lesson;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface LessonMapper {


    Lesson toEntity(LessonRequest request);

    @InheritInverseConfiguration
    LessonResponse toResponse(Lesson entity);

    List<Lesson> toEntityList(List<LessonRequest> requests);

    List<LessonResponse> toResponseList(List<Lesson> entities);
    
}
