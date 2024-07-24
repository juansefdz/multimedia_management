package com.riwi.multimedia.management.infrastructure.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.riwi.multimedia.management.api.dto.request.StudentRequest;
import com.riwi.multimedia.management.api.dto.request.update.StudentRequestUpdate;
import com.riwi.multimedia.management.api.dto.response.StudentResponse;
import com.riwi.multimedia.management.domain.entities.Student;
import com.riwi.multimedia.management.domain.repositories.StudentRepository;
import com.riwi.multimedia.management.infrastructure.abstract_services.IStudentService;
import com.riwi.multimedia.management.infrastructure.mappers.StudentMapper;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class StudentService implements IStudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private StudentMapper studentMapper;

    
    
    
    
    
    @Override
    public StudentResponse create(StudentRequest request) {
        return null;
       
    }

    @Override
    public void delete(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    @Override
    public StudentResponse update(Long id, StudentRequestUpdate request) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public Optional<StudentResponse> getById(Long id) {
       return Optional.ofNullable(this.studentMapper.toResponse(this.find(id)));
    }

    public Page<StudentResponse> getAll(Pageable pageable) {
        Page<Student> studentsPage = studentRepository.findAll(pageable);
        return studentsPage.map(studentMapper::toResponse);
    }
    public Page<StudentResponse> getAllByStatus(boolean isActive, Pageable pageable) {
        Page<Student> studentsPage = studentRepository.findAllByisActive(isActive, pageable);
        return studentsPage.map(studentMapper::toResponse);
    }

    

    private Student find(Long id) {
        return studentRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Student not found"));
    }

    
    

}
