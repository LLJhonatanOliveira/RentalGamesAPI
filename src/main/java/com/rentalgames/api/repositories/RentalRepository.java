package com.rentalgames.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.rentalgames.api.models.RentalModel;

@Repository
public interface RentalRepository extends JpaRepository<RentalModel, Long> {

  public int countByGameIdAndReturnDateIsNull(@Param("gameId") Long gameId);

}