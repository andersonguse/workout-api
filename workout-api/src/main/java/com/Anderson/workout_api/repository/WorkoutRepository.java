package com.Anderson.workout_api.repository;


import com.Anderson.workout_api.entity.Workout;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * This is the WorkoutRepository interface, an interface that handles database access so the controller
 * does not have to write SQL manually for this table. It is an interface because Spring creates
 * the implementation at runtime. You define the contract and Spring will generate the actual
 * database behavior behind the scenes. You extend JpaRepository so that you have the methods like findAll(),
 * findById(Long id), save(Workout workout) etc. You annotate it like this:
 * extends JpaRepository<EntityType, idType>
 */

public interface WorkoutRepository extends JpaRepository<Workout, Long> {

}
