
package com.riwi.multimedia.management.infrastructure.abstract_services;

import com.riwi.multimedia.management.api.dto.request.ClassRequest;
import com.riwi.multimedia.management.api.dto.response.ClassResponse;
import com.riwi.multimedia.management.infrastructure.abstract_services.generic.CreateService;
import com.riwi.multimedia.management.infrastructure.abstract_services.generic.DeleteService;
import com.riwi.multimedia.management.infrastructure.abstract_services.generic.ReadAllService;
import com.riwi.multimedia.management.infrastructure.abstract_services.generic.ReadService;


public interface IClassService  extends 
    CreateService <ClassRequest,ClassResponse>,
    DeleteService<Long>,
    ReadService<ClassResponse,Long>,
    ReadAllService<ClassResponse>{
}