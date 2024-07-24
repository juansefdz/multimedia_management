package com.riwi.multimedia.management.infrastructure.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.riwi.multimedia.management.api.dto.request.StudentRequest;
import com.riwi.multimedia.management.api.dto.request.update.StudentRequestUpdate;
import com.riwi.multimedia.management.api.dto.response.StudentResponse;
import com.riwi.multimedia.management.domain.entities.ClassEntity;
import com.riwi.multimedia.management.domain.entities.Student;
import com.riwi.multimedia.management.domain.repositories.ClassRepository;
import com.riwi.multimedia.management.domain.repositories.StudentRepository;
import com.riwi.multimedia.management.infrastructure.abstract_services.IStudentService;
import com.riwi.multimedia.management.infrastructure.mappers.StudentMapper;

import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class StudentService implements IStudentService {

    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private ClassRepository classRepository;

    @Autowired
    private StudentMapper studentMapper;

    @Override
    public StudentResponse create(StudentRequest request) {
        Student student = this.studentMapper.toEntity(request);

        ClassEntity classEntity = this.findClassById(request.getClassId());
        if (classEntity == null) {
            throw new EntityNotFoundException("Class entity not found for ID: " + request.getClassId());
        }
        student.setClassEntity(classEntity);
        Student savedStudent = this.studentRepository.save(student);

        return this.studentMapper.toResponse(savedStudent);
    }

    @Override
    public void delete(Long id) {
        Student studentDisable = this.find(id);
        if (studentDisable != null) {
            studentDisable.setIsActive(false);
            this.studentRepository.save(studentDisable);
        }
    }

    @Override
    public StudentResponse update(Long id, StudentRequestUpdate request) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    private Student find(Long id) {
        return studentRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Student not found"));
    }

    private ClassEntity findClassById(Long id) {
        return classRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Class not found for ID: " + id));
    }

    @Override
    public Optional<StudentResponse> getById(Long id) {
        return Optional.ofNullable(this.studentMapper.toResponse(this.find(id)));
    }

    public Page<StudentResponse> getAllStudents(Pageable pageable, String status, String name) {
        Page<Student> studentsPage;

        boolean isActive = "active".equalsIgnoreCase(status);

        if (name != null && !name.isEmpty()) {
            studentsPage = studentRepository.findAllByNameAndIsActive(name, isActive, pageable);
        } else {
            studentsPage = studentRepository.findAllByIsActive(isActive, pageable);
        }

        return studentsPage.map(studentMapper::toResponse);
    }

}
