package com.riwi.multimedia.management.infrastructure.abstract_services.generic;

public interface UpdateService  <Request, Response, Id> {
    Response update(Id id, Request request);
}
