package com.riwi.multimedia.management.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.riwi.multimedia.management.api.dto.response.StudentResponse;
import com.riwi.multimedia.management.infrastructure.services.StudentService;

import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;

@Tag(name = "Student's Controller", description = "Students management controller")
@RestController
@RequestMapping(path = "students")
@AllArgsConstructor
public class StudentController {

    @Autowired
    private StudentService serviceStudent;
    
    @GetMapping
    public ResponseEntity<Page<StudentResponse>> getAll(
            @Parameter(description = "Page number (default: 1)", example = "1")
            @RequestParam(defaultValue = "1") int page,
            @Parameter(description = "Number of items per page (default: 10)", example = "10")
            @RequestParam(defaultValue = "10") int size,
            @Parameter(description = "Filter by student status: 'active' or 'inactive'")
            @RequestParam(defaultValue = "active",required = false) String status,
            @Parameter(description = "Filter by name of Student")
            @RequestParam(required = false) String name) {

        PageRequest pageable = PageRequest.of(page - 1, size); 

        Page<StudentResponse> studentResponsesPage;

        if (status != null && !status.isEmpty()) {
            boolean isActive = status.equalsIgnoreCase("active");
            studentResponsesPage = serviceStudent.getAllByStatus(isActive, pageable);
        } else {
            studentResponsesPage = serviceStudent.getAll(pageable);
        }

        return ResponseEntity.ok(studentResponsesPage);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        this.serviceStudent.delete(id);
        return ResponseEntity.noContent().build();
    }

   
    
}
