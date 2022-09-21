package com.exam.tourdefrance.repository;

import com.exam.tourdefrance.model.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TeamRepository extends JpaRepository<Team, Long> {

	@Query("SELECT t FROM Team t WHERE t.name LIKE ?1")
	Optional<Team> findByName(String name);
}
