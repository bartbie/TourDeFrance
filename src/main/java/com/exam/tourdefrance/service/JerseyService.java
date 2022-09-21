package com.exam.tourdefrance.service;

import com.exam.tourdefrance.model.Rider;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.Optional;
import java.util.function.Predicate;

@Service
@RequiredArgsConstructor
public final class JerseyService {

    final RiderService riderService;

    private Predicate<Rider> agecheck(int age) {
        return (rider -> rider.getAge() > age);
    }

    public Optional<Rider> getFastestRider(@NonNull Predicate<Rider> filter) {
        return riderService.getRiders().stream()
                .filter(filter)
                .min(Comparator.comparing(Rider::getFinalTime));
    }

    public Optional<Rider> getFastestRider() {
        return getFastestRider(always_passes -> true);
    }

    public Optional<Rider> getYellowJersey() {
        return getFastestRider();
    }

    public Optional<Rider> getWhiteJersey() {
        return getFastestRider(agecheck(26));
    }

    public Optional<Rider> getGreenJersey() {
        return riderService.getRiders().stream().max(Comparator.comparing(Rider::getSprintPoints));
    }

    public Optional<Rider> getDottedJersey() {
        return riderService.getRiders().stream()
                .max(Comparator.comparing(Rider::getMountainPoints));
    }
}
