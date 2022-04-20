package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.example.demo.Exercise.Exercise;
import com.example.demo.Exercise.ExerciseRepository;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
class DemoApplicationTests {

	@Autowired
	ExerciseRepository eRepository;

	//POST Exercise
	@Test
	@Order(1)
	public void testPost () {
		Exercise exercise = new Exercise("run", 30, 200.0, "2022-03-22");
		exercise.setId(1L);
		eRepository.save(exercise);
		assertNotNull(eRepository.findById(1L).get());
	}

	@Test
	@Order(2)
	public void testReadAll () {
		List list = eRepository.findAll();
		assertThat(list).size().isGreaterThan(0);
	}

	@Test
	@Order(3)
	public void testRead () {
		Exercise exercise = eRepository.findById(1L).get();
		assertEquals("run", exercise.getName());
	}

	@Test
	@Order(4)
	public void testUpdate () {
		Exercise exercise = eRepository.findById(1L).get();
		exercise.setCaloriesBurnt(800.00);
		eRepository.save(exercise);
		assertNotEquals(200.00, eRepository.findById(1L).get().getCaloriesBurnt());
	}

	@Test
	@Order(5)
	public void testDelete () {
		eRepository.deleteById(1L);
		assertThat(eRepository.existsById(1L)).isFalse();
	}
}
