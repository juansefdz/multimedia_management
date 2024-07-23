package com.riwi.multimedia.management.infrastructure.mappers;

import com.riwi.multimedia.management.api.dto.request.StudentRequest;
import com.riwi.multimedia.management.api.dto.request.update.StudentRequestUpdate;
import com.riwi.multimedia.management.api.dto.response.StudentResponse;
import com.riwi.multimedia.management.domain.entities.Student;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-07-23T09:50:22-0500",
    comments = "version: 1.5.5.Final, compiler: Eclipse JDT (IDE) 3.39.0.v20240620-1855, environment: Java 17.0.11 (Eclipse Adoptium)"
)
@Component
public class StudentMapperImpl implements StudentMapper {

    @Override
    public Student toEntity(StudentRequest request) {
        if ( request == null ) {
            return null;
        }

        Student student = new Student();

        student.setClassId( request.getClassId() );
        student.setCreatedAt( request.getCreatedAt() );
        student.setEmail( request.getEmail() );
        student.setId( request.getId() );
        student.setIsActive( request.getIsActive() );
        student.setName( request.getName() );

        return student;
    }

    @Override
    public StudentResponse toResponse(Student entity) {
        if ( entity == null ) {
            return null;
        }

        StudentResponse studentResponse = new StudentResponse();

        studentResponse.setClassId( entity.getClassId() );
        studentResponse.setCreatedAt( entity.getCreatedAt() );
        studentResponse.setEmail( entity.getEmail() );
        studentResponse.setId( entity.getId() );
        studentResponse.setIsActive( entity.getIsActive() );
        studentResponse.setName( entity.getName() );

        return studentResponse;
    }

    @Override
    public Student toEntityUpdate(StudentRequestUpdate request) {
        if ( request == null ) {
            return null;
        }

        Student student = new Student();

        student.setEmail( request.getEmail() );
        student.setName( request.getName() );

        return student;
    }

    @Override
    public List<Student> toEntityList(List<StudentRequest> requests) {
        if ( requests == null ) {
            return null;
        }

        List<Student> list = new ArrayList<Student>( requests.size() );
        for ( StudentRequest studentRequest : requests ) {
            list.add( toEntity( studentRequest ) );
        }

        return list;
    }

    @Override
    public List<StudentResponse> toResponseList(List<Student> entities) {
        if ( entities == null ) {
            return null;
        }

        List<StudentResponse> list = new ArrayList<StudentResponse>( entities.size() );
        for ( Student student : entities ) {
            list.add( toResponse( student ) );
        }

        return list;
    }
}
