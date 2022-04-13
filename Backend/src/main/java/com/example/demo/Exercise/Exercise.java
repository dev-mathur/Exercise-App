package com.example.demo.Exercise;

import java.util.Date;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Exercise {
    private @Id @GeneratedValue Long id;
    private String name;
    private int duration;
    private double caloriesBurnt;
    private String date;

    //Default constructor
    Exercise() {}

    //RequiredArgs Constructor
    Exercise(String name, int duration, double caloriesBurnt, String date) {
        this.name = name;
        this.duration = duration;
        this.caloriesBurnt = caloriesBurnt;
        this.date = date;
    }

    //Getter methods
    public Long getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public double getCaloriesBurnt() {
        return this.caloriesBurnt;
    }

    public int getDuration() {
        return this.duration;
    }

    public String getDate() {
        return this.date;
    }

    //Setter Methods
    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCaloriesBurnt(double caloriesBurnt) {
        this.caloriesBurnt = caloriesBurnt;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public void setDate(String date) {
        this.date = date;
    }

    //toString method
    @Override
    public String toString() {
      return "Exercise{" + "id=" + this.id + ", name='" + this.name + '\'' + ", Calories Burnt='" 
      + this.caloriesBurnt + '\'' + ", duration='" + this.duration + ", date='" + this.date + '\'' + '}';
    }
}
