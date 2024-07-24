package com.riwi.multimedia.management.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.riwi.multimedia.management.api.dto.errors.BaseErrorResponse;
import com.riwi.multimedia.management.api.dto.request.StudentRequest;
import com.riwi.multimedia.management.api.dto.request.update.StudentRequestUpdate;
import com.riwi.multimedia.management.api.dto.response.StudentResponse;
import com.riwi.multimedia.management.infrastructure.services.StudentService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PostMapping;



@Tag(name = "Student's Controller", description = "Students management controller")
@RestController
@RequestMapping(path = "students")
@AllArgsConstructor
public class StudentController {

    @Autowired
    private StudentService serviceStudent;
    


     /*----------------------
     * GET ALL STUDENTS
     * ---------------------
     */
    // SWAGGER
    @Operation(
        summary = "Get all students",
        description = "Retrieve a paginated list of all students",
        parameters = {
            @Parameter(
                name = "page", 
                description = "Page number", 
                schema = @Schema(type = "integer", defaultValue = "1")),
            @Parameter(
                name = "size", 
                description = "Page size", 
                schema = @Schema(type = "integer", defaultValue = "10")),
            @Parameter(
                name = "status", 
                description = "Filter by student status: 'active'", 
                schema = @Schema(type = "string", defaultValue = "active")),
            @Parameter(
                name = "name", 
                description = "Filter by name of Student", 
                schema = @Schema(type = "string"))
        },
         responses = {
            @ApiResponse(
                responseCode = "200", description = "SUCCESSFUL", 
                content = @Content(schema = @Schema(implementation = Page.class))),
            @ApiResponse(
                responseCode = "400", description = "BAD REQUEST", 
                content = @Content(schema = @Schema(implementation = BaseErrorResponse.class))),
            @ApiResponse(
                responseCode = "401", description = "NOT AUTHORIZED", 
                content = @Content(schema = @Schema(implementation = BaseErrorResponse.class))),
            @ApiResponse(
                responseCode = "403", description = "FORBIDDEN ACCESS", 
                content = @Content(schema = @Schema(implementation = BaseErrorResponse.class))),
            @ApiResponse(
                responseCode = "500", description = "INTERNAL SERVER ERROR", 
                content = @Content(schema = @Schema(implementation = BaseErrorResponse.class)))
        }
    )
    @GetMapping
    public ResponseEntity<Page<StudentResponse>> getAll(
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "active") String status,
            @RequestParam(required = false) String name) {

        PageRequest pageable = PageRequest.of(page - 1, size);
        Page<StudentResponse> studentResponsesPage = serviceStudent.getAllStudents(pageable, status, name);
        return ResponseEntity.ok(studentResponsesPage);
    }

    /*--------------------
     * GET BY ID
     * -------------------
     */
   @Operation(
    summary = "Get Student by ID", 
    description = "Get a student by their ID"
    )
    @ApiResponses({
        @ApiResponse(
            responseCode = "200", 
            description = "SUCCESSFUL", 
            content = @Content(schema = @Schema(implementation = StudentResponse.class))
        ),
        @ApiResponse(
            responseCode = "400", 
            description = "BAD REQUEST", 
            content = @Content(schema = @Schema(implementation = BaseErrorResponse.class))
        ),
        @ApiResponse(
            responseCode = "401", 
            description = "NOT AUTHORIZED", 
            content = @Content(schema = @Schema(implementation = BaseErrorResponse.class))
        ),
        @ApiResponse(
            responseCode = "403", 
            description = "FORBIDDEN ACCESS", 
            content = @Content(schema = @Schema(implementation = BaseErrorResponse.class))
        ),
        @ApiResponse(
            responseCode = "500", 
            description = "INTERNAL SERVER ERROR", 
            content = @Content(schema = @Schema(implementation = BaseErrorResponse.class))
        )
    })
    @GetMapping(path = "/{id}")
    public ResponseEntity<StudentResponse> getById(@PathVariable Long id) {
        return ResponseEntity.ok(this.serviceStudent.getById(id).orElse(null));
    }

    /*--------------------
     * CREATE STUDENT
     * -------------------
     */
    @PostMapping  
    public ResponseEntity <StudentResponse> create (@RequestBody StudentRequest request){
        StudentResponse studentResponse = this.serviceStudent.create(request);
        return ResponseEntity.ok(studentResponse);
    }

     
    /*--------------------
     * UPDATE STUDENT
     * -------------------
     */
    @PutMapping(path = "/{id}")
    public String putMethodName(@PathVariable String id, @RequestBody String entity) {
        //TODO: process PUT request
        
        return entity;
    }
     public ResponseEntity <StudentResponse> update (@PathVariable Long id, @RequestBody StudentRequestUpdate request){
        StudentResponse studentResponse = this.serviceStudent.update(id, request);
        return ResponseEntity.ok(studentResponse);
    }

     /*--------------------
     * DISABLE STUDENT
     * -------------------
     */


    @Operation(
        summary = "Disable a student",
        description = "Disables a student by their ID",
        responses = {
            @ApiResponse(
                responseCode = "200", description = "SUCCESSFUL", 
                content = @Content(schema = @Schema(implementation = Page.class))),
            @ApiResponse(
                responseCode = "400", description = "BAD REQUEST", 
                content = @Content(schema = @Schema(implementation = BaseErrorResponse.class))),
            @ApiResponse(
                responseCode = "401", description = "NOT AUTHORIZED", 
                content = @Content(schema = @Schema(implementation = BaseErrorResponse.class))),
            @ApiResponse(
                responseCode = "403", description = "FORBIDDEN ACCESS", 
                content = @Content(schema = @Schema(implementation = BaseErrorResponse.class))),
            @ApiResponse(
                responseCode = "500", description = "INTERNAL SERVER ERROR", 
                content = @Content(schema = @Schema(implementation = BaseErrorResponse.class)))
        }
    )

    @PatchMapping (path = "/{id}/disable")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        this.serviceStudent.delete(id);
        return ResponseEntity.ok().build();
    }

   
    
}
