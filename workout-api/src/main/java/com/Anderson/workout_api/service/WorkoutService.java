package com.Anderson.workout_api.service;

import com.Anderson.workout_api.entity.Workout;
import com.Anderson.workout_api.exception.WorkoutNotFoundException;
import com.Anderson.workout_api.repository.WorkoutRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
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

    public Workout getWorkout(Long id){
        Workout workout = workoutRepository.findById(id).orElseThrow();
        return workout;
    }

    public Workout createWorkout(Workout workout) {
        return workoutRepository.save(workout);
    }

    public Workout updateWorkout(Long id, Workout workout){
        Workout existingWorkout = workoutRepository.findById(id).orElseThrow();
        existingWorkout.setStartTime(workout.getStartTime());
        existingWorkout.setEndTime(workout.getEndTime());
        existingWorkout.setSets(workout.getSets());
        existingWorkout.setTotalRestSeconds(workout.getTotalRestSeconds());
        existingWorkout.setTotalWorkSeconds(workout.getTotalWorkSeconds());

        return workoutRepository.save(existingWorkout);
    }

    public void deleteWorkout(Long id) {
        if (!workoutRepository.existsById(id)) {
            throw new WorkoutNotFoundException(id);
        }
        workoutRepository.deleteById(id);
    }

}
