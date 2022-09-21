package com.exam.tourdefrance.service;

import com.exam.tourdefrance.model.Rider;
import com.exam.tourdefrance.repository.RiderRepository;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public final class RiderService {
  final RiderRepository riderRepo;

  public List<Rider> getRiders() {
    return riderRepo.findAll();
  }

  public void addRider(@NonNull Rider rider) throws IllegalStateException {
    if (getRiders().stream().anyMatch(rider::equals)) {  // TODO: change it to searching for fName and lName
      throw new IllegalStateException("Rider already exists");
    }
    riderRepo.save(rider);
  }

  public Optional<Rider> findRiderById(long id) {
    return riderRepo.findById(id);
  }

}
