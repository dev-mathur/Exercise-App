package com.example.demo.Exercise;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:3000/")
@RestController
public class ExerciseController {
    
    private final ExerciseRepository repository;

    ExerciseController(ExerciseRepository repository) {
      this.repository = repository;
    }


  @GetMapping("/exercises")
  List<Exercise> all() {
    return repository.findAll();
  }
  

  @PostMapping("/exercise")
  Exercise newEmployee(@RequestBody Exercise newExercise) {
    return repository.save(newExercise);
  }

  // Single item
  @GetMapping("/exercise/{id}")
  Exercise one(@PathVariable Long id) {
    
    return repository.findById(id)
      .orElseThrow(() -> new ExerciseNotFoundException(id));
  }

  @PutMapping("/exercise/{id}")
  Exercise changeExercise(@RequestBody Exercise newExercise, @PathVariable Long id) {
    
    return repository.findById(id)
      .map(exercise -> {
        exercise.setName(newExercise.getName());
        exercise.setDuration(newExercise.getDuration());
        exercise.setCaloriesBurnt(newExercise.getCaloriesBurnt());
        exercise.setDate(newExercise.getDate());
        return repository.save(exercise);
      })
      .orElseGet(() -> {
        newExercise.setId(id);
        return repository.save(newExercise);
      });
  }

  @DeleteMapping("/exercise/{id}")
  void deleteExercise(@PathVariable Long id) {
    repository.deleteById(id);
  }
}
