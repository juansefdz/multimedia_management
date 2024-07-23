package com.riwi.multimedia.management.domain.entities;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "classes")
public class ClassEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long idClass;

    @Column(name= "name_class", nullable = false)
    private String nameClass;

    @Column(name= "description",nullable = false, columnDefinition = "TEXT")
    private String description;

    @Column(name = "created_at", nullable = false)
    private LocalDate createdAt = LocalDate.now();

    @Column(nullable = false)
    private Boolean isActive;

    @OneToMany(mappedBy = "class",cascade = CascadeType.ALL)
    private List<Lesson> lessons;

    @OneToMany(mappedBy = "class",cascade = CascadeType.ALL)
    private List<Student> students;
    
}
