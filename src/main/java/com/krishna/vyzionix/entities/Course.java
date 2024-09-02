package com.krishna.vyzionix.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "vz_courses")
public class Course {

    @Id
    private String courseId;
    private String title;

    @OneToMany(mappedBy = "course")
    private List<Video> videos = new ArrayList<>();


}
