package com.exam.tourdefrance.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
@Getter
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public final class Team {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Setter(AccessLevel.NONE)
  private Long id;

  @NotNull private String name;

  public Team(@NonNull String name) {
    this.name = name;
  }
}
