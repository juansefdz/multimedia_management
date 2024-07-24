package com.riwi.multimedia.management.api.dto.request;

import java.time.LocalDate;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;




@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class StudentRequest {

    @Schema(description = "Name of the Student", example = "John Doe")
    @NotBlank(message = "The Student name is required")
    private String name;
    
    @Schema(description = "Email of the Student", example = "JohnDoe@Example.com")
    @NotBlank(message = "The email of the Student is required")
    @Email(message = "Enter a valid email address")
    private String email;
    
    @Schema(description = "Date of student creation in the register", example = "2024-12-31")
    private LocalDate createdAt;
    @Schema(description = "Status of the Student,can bee true (active) or false (inactive) ", example = "true")
    private Boolean isActive;
    
    @Schema(description = "Id of the Class", example = "1")
    @NotNull(message = "The id of the Class is required")
    private Long classId;
    
}
