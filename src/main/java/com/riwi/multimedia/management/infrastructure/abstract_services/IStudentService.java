package com.riwi.multimedia.management.infrastructure.abstract_services;

import com.riwi.multimedia.management.api.dto.request.StudentRequest;
import com.riwi.multimedia.management.api.dto.request.update.StudentRequestUpdate;
import com.riwi.multimedia.management.api.dto.response.StudentResponse;
import com.riwi.multimedia.management.infrastructure.abstract_services.generic.CreateService;
import com.riwi.multimedia.management.infrastructure.abstract_services.generic.DeleteService;
import com.riwi.multimedia.management.infrastructure.abstract_services.generic.ReadAllService;
import com.riwi.multimedia.management.infrastructure.abstract_services.generic.ReadService;
import com.riwi.multimedia.management.infrastructure.abstract_services.generic.UpdateService;

public interface IStudentService extends 
    CreateService <StudentRequest,StudentResponse>,
    DeleteService<Long>,
    UpdateService<StudentRequestUpdate,StudentResponse,Long>,
    ReadService<StudentResponse,Long>,
    ReadAllService<StudentResponse>{
    
}
