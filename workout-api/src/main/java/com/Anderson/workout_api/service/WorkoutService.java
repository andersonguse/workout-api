package com.Anderson.workout_api.service;

import com.Anderson.workout_api.dto.WorkoutRequest;
import com.Anderson.workout_api.dto.WorkoutResponse;
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

    public List<WorkoutResponse> getAllWorkouts(){
        return this.workoutRepository.findAll()
                .stream()
                .map(workout -> new WorkoutResponse(
                        workout.getId(),
                        workout.getStartTime(),
                        workout.getEndTime(),
                        workout.getSets(),
                        workout.getTotalRestSeconds(),
                        workout.getTotalWorkSeconds()
                ))
                .toList();
    }

    public WorkoutResponse getWorkout(Long id){
        Workout workout = workoutRepository.findById(id).orElseThrow(() -> new WorkoutNotFoundException(id));
        return new WorkoutResponse(
                workout.getId(),
                workout.getStartTime(),
                workout.getEndTime(),
                workout.getSets(),
                workout.getTotalRestSeconds(),
                workout.getTotalWorkSeconds()
        );
    }

    public WorkoutResponse createWorkout(WorkoutRequest request) {

        Workout workout = new Workout();
        workout.setStartTime(request.getStartTime());
        workout.setEndTime(request.getEndTime());
        workout.setSets(request.getSets());
        workout.setTotalRestSeconds(request.getTotalRestSeconds());
        workout.setTotalWorkSeconds(request.getTotalWorkSeconds());
        Workout savedWorkout = workoutRepository.save(workout);

        return new WorkoutResponse(
                savedWorkout.getId(),
                savedWorkout.getStartTime(),
                savedWorkout.getEndTime(),
                savedWorkout.getSets(),
                savedWorkout.getTotalRestSeconds(),
                savedWorkout.getTotalWorkSeconds()
        );
    }

    public WorkoutResponse updateWorkout(Long id, WorkoutRequest request){
        Workout existingWorkout = workoutRepository.findById(id).orElseThrow(() -> new WorkoutNotFoundException(id));
        existingWorkout.setStartTime(request.getStartTime());
        existingWorkout.setEndTime(request.getEndTime());
        existingWorkout.setSets(request.getSets());
        existingWorkout.setTotalRestSeconds(request.getTotalRestSeconds());
        existingWorkout.setTotalWorkSeconds(request.getTotalWorkSeconds());
        Workout savedWorkout = workoutRepository.save(existingWorkout);

        return new WorkoutResponse(
                savedWorkout.getId(),
                savedWorkout.getStartTime(),
                savedWorkout.getEndTime(),
                savedWorkout.getSets(),
                savedWorkout.getTotalRestSeconds(),
                savedWorkout.getTotalWorkSeconds()
        );
    }

    public void deleteWorkout(Long id) {
        if (!workoutRepository.existsById(id)) {
            throw new WorkoutNotFoundException(id);
        }
        workoutRepository.deleteById(id);
    }

}
