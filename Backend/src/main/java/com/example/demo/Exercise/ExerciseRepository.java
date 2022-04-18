package com.example.demo.Exercise;

import org.springframework.data.jpa.repository.JpaRepository;

//Allow persistent data in H2 DB
public interface ExerciseRepository extends JpaRepository<Exercise, Long>{
    
}
