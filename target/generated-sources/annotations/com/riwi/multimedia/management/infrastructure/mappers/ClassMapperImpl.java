package com.riwi.multimedia.management.infrastructure.mappers;

import com.riwi.multimedia.management.api.dto.request.ClassRequest;
import com.riwi.multimedia.management.api.dto.response.ClassResponse;
import com.riwi.multimedia.management.domain.entities.ClassEntity;
import com.riwi.multimedia.management.domain.entities.Lesson;
import com.riwi.multimedia.management.domain.entities.Student;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-07-24T08:51:08-0500",
    comments = "version: 1.5.5.Final, compiler: Eclipse JDT (IDE) 3.39.0.v20240620-1855, environment: Java 17.0.11 (Eclipse Adoptium)"
)
@Component
public class ClassMapperImpl implements ClassMapper {

    @Override
    public ClassEntity toEntity(ClassRequest request) {
        if ( request == null ) {
            return null;
        }

        ClassEntity classEntity = new ClassEntity();

        if ( request.getCreatedAt() != null ) {
            classEntity.setCreatedAt( Date.from( request.getCreatedAt().atStartOfDay( ZoneOffset.UTC ).toInstant() ) );
        }
        classEntity.setDescription( request.getDescription() );
        classEntity.setId( request.getId() );
        classEntity.setIsActive( request.getIsActive() );
        List<Lesson> list = request.getLessons();
        if ( list != null ) {
            classEntity.setLessons( new ArrayList<Lesson>( list ) );
        }
        classEntity.setName( request.getName() );
        List<Student> list1 = request.getStudents();
        if ( list1 != null ) {
            classEntity.setStudents( new ArrayList<Student>( list1 ) );
        }

        return classEntity;
    }

    @Override
    public ClassResponse toResponse(ClassEntity entity) {
        if ( entity == null ) {
            return null;
        }

        ClassResponse classResponse = new ClassResponse();

        classResponse.setDescription( entity.getDescription() );
        classResponse.setIsActive( entity.getIsActive() );

        return classResponse;
    }
}
