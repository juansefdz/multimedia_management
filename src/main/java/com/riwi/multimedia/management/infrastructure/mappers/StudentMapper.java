package com.riwi.multimedia.management.infrastructure.mappers;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.Mappings;

import java.util.List;

import com.riwi.multimedia.management.api.dto.request.StudentRequest;
import com.riwi.multimedia.management.api.dto.request.update.StudentRequestUpdate;
import com.riwi.multimedia.management.api.dto.response.StudentResponse;
import com.riwi.multimedia.management.domain.entities.Student;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface StudentMapper {


    Student toEntity(StudentRequest request);

    @InheritInverseConfiguration
    StudentResponse toResponse(Student entity);

    @Mappings({
            @Mapping(target = "id", ignore = true),
            @Mapping(target = "createdAt", ignore = true),
            @Mapping(target = "isActive", ignore = true),
            @Mapping(target = "classId", ignore = true)
    })

    Student toEntityUpdate(StudentRequestUpdate request);

    List<Student> toEntityList(List<StudentRequest> requests);

    List<StudentResponse> toResponseList(List<Student> entities);
}
