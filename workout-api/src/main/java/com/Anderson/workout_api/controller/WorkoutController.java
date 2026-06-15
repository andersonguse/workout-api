package com.Anderson.workout_api.controller;

import com.Anderson.workout_api.entity.Workout;
import com.Anderson.workout_api.service.WorkoutService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/workouts")
public class WorkoutController {

    private final WorkoutService workoutService;

    public WorkoutController(WorkoutService workoutService){
        this.workoutService = workoutService;
    }

    @GetMapping
    public List<Workout> getAllWorkouts(){
        return this.workoutService.getAllWorkouts();
    }

    @GetMapping("/{id}")
    public Workout getWorkout(@PathVariable Long id){
        return workoutService.getWorkout(id);
    }

    @PostMapping
    public Workout createWorkout(@RequestBody Workout workout) {
        return workoutService.createWorkout(workout);
    }

}
