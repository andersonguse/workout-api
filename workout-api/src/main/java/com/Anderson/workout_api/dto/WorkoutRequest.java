package com.Anderson.workout_api.dto;

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
public class WorkoutRequest {

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
