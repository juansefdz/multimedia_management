package com.riwi.multimedia.management.infrastructure.mappers;

import com.riwi.multimedia.management.api.dto.request.LessonRequest;
import com.riwi.multimedia.management.api.dto.response.LessonResponse;
import com.riwi.multimedia.management.domain.entities.Lesson;
import com.riwi.multimedia.management.domain.entities.Multimedia;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-07-24T08:51:08-0500",
    comments = "version: 1.5.5.Final, compiler: Eclipse JDT (IDE) 3.39.0.v20240620-1855, environment: Java 17.0.11 (Eclipse Adoptium)"
)
@Component
public class LessonMapperImpl implements LessonMapper {

    @Override
    public Lesson toEntity(LessonRequest request) {
        if ( request == null ) {
            return null;
        }

        Lesson lesson = new Lesson();

        lesson.setContent( request.getContent() );
        lesson.setCreatedAt( request.getCreatedAt() );
        lesson.setId( request.getId() );
        lesson.setIsActive( request.getIsActive() );
        List<Multimedia> list = request.getMultimediaList();
        if ( list != null ) {
            lesson.setMultimediaList( new ArrayList<Multimedia>( list ) );
        }
        lesson.setTitle( request.getTitle() );

        return lesson;
    }

    @Override
    public LessonResponse toResponse(Lesson entity) {
        if ( entity == null ) {
            return null;
        }

        LessonResponse lessonResponse = new LessonResponse();

        lessonResponse.setContent( entity.getContent() );
        lessonResponse.setCreatedAt( entity.getCreatedAt() );
        lessonResponse.setId( entity.getId() );
        lessonResponse.setIsActive( entity.getIsActive() );
        lessonResponse.setTitle( entity.getTitle() );

        return lessonResponse;
    }

    @Override
    public List<Lesson> toEntityList(List<LessonRequest> requests) {
        if ( requests == null ) {
            return null;
        }

        List<Lesson> list = new ArrayList<Lesson>( requests.size() );
        for ( LessonRequest lessonRequest : requests ) {
            list.add( toEntity( lessonRequest ) );
        }

        return list;
    }

    @Override
    public List<LessonResponse> toResponseList(List<Lesson> entities) {
        if ( entities == null ) {
            return null;
        }

        List<LessonResponse> list = new ArrayList<LessonResponse>( entities.size() );
        for ( Lesson lesson : entities ) {
            list.add( toResponse( lesson ) );
        }

        return list;
    }
}
