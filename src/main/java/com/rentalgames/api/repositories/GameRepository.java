package com.rentalgames.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rentalgames.api.models.GameModel;

@Repository
public interface GameRepository extends JpaRepository<GameModel, Long> {
  public boolean existsByName(String name);
}
