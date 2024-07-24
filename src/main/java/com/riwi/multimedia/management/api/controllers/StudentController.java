package com.riwi.multimedia.management.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.riwi.multimedia.management.api.dto.response.StudentResponse;
import com.riwi.multimedia.management.infrastructure.services.StudentService;

import io.swagger.v3.oas.annotations.Parameter;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping(path = "students")
@AllArgsConstructor
public class StudentController {

    @Autowired
    private StudentService serviceStudent;
    
    @GetMapping("/students")
    public ResponseEntity<Page<StudentResponse>> getAll(
            @Parameter(description = "Page number (default: 1)", example = "1")
            @RequestParam(defaultValue = "1") int page,
            @Parameter(description = "Number of items per page (default: 10)", example = "10")
            @RequestParam(defaultValue = "10") int size,
            @Parameter(description = "Filter by student status: 'active' or 'inactive'")
            @RequestParam(required = false) String status) {

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
    
}
