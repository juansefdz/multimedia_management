package com.riwi.multimedia.management.infrastructure.mappers;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;


import com.riwi.multimedia.management.api.dto.request.ClassRequest;
import com.riwi.multimedia.management.api.dto.response.ClassResponse;
import com.riwi.multimedia.management.domain.entities.ClassEntity;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface ClassMapper {

    ClassEntity toEntity(ClassRequest request);
    
    @InheritInverseConfiguration
    ClassResponse toResponse(ClassEntity entity);

    
}
