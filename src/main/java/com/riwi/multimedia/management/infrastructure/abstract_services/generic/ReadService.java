package com.riwi.multimedia.management.infrastructure.abstract_services.generic;

import java.util.Optional;

public interface ReadService<Response, Id> {
    Optional<Response> getById(Id id);
}