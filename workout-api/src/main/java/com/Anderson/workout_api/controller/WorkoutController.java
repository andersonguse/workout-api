package com.Anderson.workout_api.controller;

import com.Anderson.workout_api.dto.WorkoutRequest;
import com.Anderson.workout_api.dto.WorkoutResponse;
import com.Anderson.workout_api.entity.Workout;
import com.Anderson.workout_api.service.WorkoutService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<List<WorkoutResponse>> getAllWorkouts() {
        return ResponseEntity.ok(workoutService.getAllWorkouts());
    }

    @GetMapping("/{id}")
    public ResponseEntity<WorkoutResponse> getWorkout(@PathVariable Long id){
        return ResponseEntity.ok(workoutService.getWorkout(id));
    }

    @PostMapping
    public ResponseEntity<WorkoutResponse> createWorkout(@Valid @RequestBody WorkoutRequest request) {
        WorkoutResponse createdWorkout = workoutService.createWorkout(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdWorkout);
    }

    @PutMapping("/{id}")
    public ResponseEntity<WorkoutResponse> updateWorkout(@PathVariable Long id, @Valid @RequestBody WorkoutRequest request) {
        WorkoutResponse updatedWorkout = workoutService.updateWorkout(id, request);
        return ResponseEntity.ok(updatedWorkout);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteWorkout(@PathVariable Long id){
        workoutService.deleteWorkout(id);
        return ResponseEntity.noContent().build();
    }

}
