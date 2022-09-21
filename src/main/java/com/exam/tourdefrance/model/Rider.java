package com.exam.tourdefrance.model;

import com.exam.tourdefrance.converter.DurationToStringConverter;
import com.exam.tourdefrance.lib.TimeUtils;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.Duration;

@Entity
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
public final class Rider {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private Long id;

    @NotNull private String firstName;
    @NotNull private String lastName;
    @NotNull private Integer age;
    @NotNull private Double mountainPoints;
    @NotNull private Double sprintPoints;

    @Convert(converter = DurationToStringConverter.class)
    @NotNull
    private Duration finalTime;

    public Rider(
            @NonNull String firstName,
            @NonNull String lastName,
            int age,
            double mountainPoints,
            double sprintPoints,
            @NonNull Duration finalTime) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.mountainPoints = mountainPoints;
        this.sprintPoints = sprintPoints;
        this.finalTime = finalTime;
    }

    @Override
    public String toString() {
        return "Rider{id=%d, firstName='%s', lastName='%s', age=%d, mountain_points=%s, sprint_points=%s, finalTime=%s}"
                .formatted(
                        id,
                        firstName,
                        lastName,
                        age,
                        mountainPoints,
                        sprintPoints,
                        TimeUtils.DurationToStr(finalTime));
    }
}
