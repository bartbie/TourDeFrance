package com.exam.tourdefrance.repository;

import com.exam.tourdefrance.model.Rider;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RiderRepository extends JpaRepository<Rider, Long> {}
