package com.Anderson.workout_api.service;

import com.Anderson.workout_api.entity.Workout;
import com.Anderson.workout_api.repository.WorkoutRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class WorkoutService {

    private final WorkoutRepository workoutRepository;

    public WorkoutService(WorkoutRepository workoutRepository){
        this.workoutRepository = workoutRepository;
    }

    public List<Workout> getAllWorkouts(){
        return this.workoutRepository.findAll();
    }

}
