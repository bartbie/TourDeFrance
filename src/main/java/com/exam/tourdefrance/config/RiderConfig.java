package com.exam.tourdefrance.config;

import com.exam.tourdefrance.model.Rider;
import com.exam.tourdefrance.repository.RiderRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.time.Duration;

@Configuration
public class RiderConfig {

  @Bean
  CommandLineRunner commandLineRunner(RiderRepository riderRepo) {
    return args -> {
      var duration = Duration.ofMillis(100090);
      print("Duration:", duration.toMillis());
      var rider = new Rider();
      print("Rider: ", rider);
      riderRepo.save(rider);
      print(riderRepo.findAll());
    };
  }

  void print(Object... x) {
    for (Object o : x) {
      System.out.print(o + " ");
    }
    System.out.println();
  }
}
