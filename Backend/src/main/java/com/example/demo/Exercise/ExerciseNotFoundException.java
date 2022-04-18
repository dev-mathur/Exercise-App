package com.example.demo.Exercise;

public class ExerciseNotFoundException extends RuntimeException {
  //Provide exception if exercise with ID is NOT found
    ExerciseNotFoundException(Long id) {
      super("Could not find exercise " + id);
    }
  }