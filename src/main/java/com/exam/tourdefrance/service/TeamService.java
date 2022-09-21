package com.exam.tourdefrance.service;

import com.exam.tourdefrance.model.Team;
import com.exam.tourdefrance.repository.TeamRepository;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public final class TeamService {
	final TeamRepository teamRepo;

	public List<Team> getTeams() {
		return teamRepo.findAll();
	}

	public void addTeam(@NonNull Team team) throws IllegalStateException {
		if (findTeamByName(team.getName()).isPresent()) {
			/*
			 TODO:
			  change for something like this maybe
			  getTeams().stream().map(Team::getName).anyMatch(team.getName()::equalsIgnoreCase)
			*/
			throw new IllegalStateException("Team name already taken");
		}
		teamRepo.save(team);
	}


	public Optional<Team> findTeamById(long id) {
		return teamRepo.findById(id);
	}

	public Optional<Team> findTeamByName(@NonNull String name) {
		return teamRepo.findByName(name);
	}

}
