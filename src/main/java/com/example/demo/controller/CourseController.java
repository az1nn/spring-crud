package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Course;
import com.example.demo.repository.CourseRepository;

@RestController
public class CourseController {

  @Autowired
  private CourseRepository courseRepository;

  @GetMapping(value="api/courses")
  public @ResponseBody List<Course> list() {
      return courseRepository.findAll();
  }

  @PostMapping(value="api/courses")
  @ResponseStatus(code = HttpStatus.CREATED)
  public Course create(@RequestBody Course course) {
      return courseRepository.save(course);
  }
  
}
