package com.riwi.multimedia.management.infrastructure.services;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.riwi.multimedia.management.api.dto.request.ClassRequest;
import com.riwi.multimedia.management.api.dto.response.ClassResponse;
import com.riwi.multimedia.management.infrastructure.abstract_services.IClassService;

import lombok.AllArgsConstructor;


@Service
@AllArgsConstructor
public class ClassService implements IClassService{

    @Override
    public ClassResponse create(ClassRequest request) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'create'");
    }

    @Override
    public void delete(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    @Override
    public Optional<ClassResponse> getById(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getById'");
    }

    @Override
    public Page<ClassResponse> getAll(Pageable pageable) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAll'");
    }
    
}
