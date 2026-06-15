package com.Anderson.workout_api.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name="workouts")

/**
 * This is the Workout class, an entity that represents the workouts table in the database.
 */

public class Workout {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    private LocalDateTime startTime;
    @NotNull
    private LocalDateTime endTime;
    @NotNull
    @Positive
    private Integer sets;
    @NotNull
    @PositiveOrZero
    private Integer totalRestSeconds;
    @NotNull
    @Positive
    private Integer totalWorkSeconds;

}
