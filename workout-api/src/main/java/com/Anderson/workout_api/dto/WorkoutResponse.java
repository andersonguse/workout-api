package com.Anderson.workout_api.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class WorkoutResponse {

    private Long id;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private Integer sets;
    private Integer totalRestSeconds;
    private Integer totalWorkSeconds;
}
