package com.riwi.multimedia.management.infrastructure.abstract_services.generic;

public interface CreateService <Request, Response>{
    Response create(Request request);
    
}
