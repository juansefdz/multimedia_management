package com.riwi.multimedia.management.infrastructure.abstract_services;

import com.riwi.multimedia.management.api.dto.request.MultimediaRequest;
import com.riwi.multimedia.management.api.dto.response.MultimediaResponse;
import com.riwi.multimedia.management.infrastructure.abstract_services.generic.CreateService;
import com.riwi.multimedia.management.infrastructure.abstract_services.generic.DeleteService;
import com.riwi.multimedia.management.infrastructure.abstract_services.generic.ReadAllService;
import com.riwi.multimedia.management.infrastructure.abstract_services.generic.ReadService;

public interface IMultimediaService extends 
    CreateService <MultimediaRequest,MultimediaResponse>,
    DeleteService<Long>,
    ReadService<MultimediaResponse,Long>,
    ReadAllService<MultimediaResponse>{
    
}
