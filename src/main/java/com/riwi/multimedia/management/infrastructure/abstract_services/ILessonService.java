package com.riwi.multimedia.management.infrastructure.abstract_services;

import com.riwi.multimedia.management.api.dto.request.LessonRequest;
import com.riwi.multimedia.management.api.dto.response.LessonResponse;
import com.riwi.multimedia.management.infrastructure.abstract_services.generic.CreateService;
import com.riwi.multimedia.management.infrastructure.abstract_services.generic.DeleteService;
import com.riwi.multimedia.management.infrastructure.abstract_services.generic.ReadAllService;
import com.riwi.multimedia.management.infrastructure.abstract_services.generic.ReadService;

public interface ILessonService  extends 
    CreateService <LessonRequest,LessonResponse>,
    DeleteService<Long>,
    ReadService<LessonResponse,Long>,
    ReadAllService<LessonResponse>{
    
}
