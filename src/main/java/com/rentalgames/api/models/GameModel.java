package com.rentalgames.api.models;

import com.rentalgames.api.dtos.GameDTO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "games")
public class GameModel {
  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  private Long id;

  @Column(nullable = false, unique = true, length = 255)
  private String name;

  @Column(nullable = false)
  private String image;

  @Column(nullable = false)
  private int stockTotal;

  @Column(nullable = false)
  private int pricePerDay;

  public GameModel(GameDTO dto) {
    this.name = dto.getName();
    this.image = dto.getImage();
    this.stockTotal = dto.getStockTotal();
    this.pricePerDay = dto.getPricePerDay();
  }
}