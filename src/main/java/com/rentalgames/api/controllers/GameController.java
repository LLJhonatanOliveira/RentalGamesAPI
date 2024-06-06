package com.rentalgames.api.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.rentalgames.api.dtos.GameDTO;
import com.rentalgames.api.models.GameModel;
import com.rentalgames.api.services.GameService;

import jakarta.validation.Valid;



@RestController
@RequestMapping("games")
public class GameController {

  private final GameService gameService;

  public GameController(GameService gameService) {
    this.gameService = gameService;
  }

  @GetMapping
  public ResponseEntity<List<GameModel>> getAllGames() {
    return ResponseEntity.status(HttpStatus.OK).body(gameService.findAll());
  }

  @GetMapping("/{id}")
  public ResponseEntity<GameModel> getGameById(@PathVariable("id") Long id) {
    return ResponseEntity.status(HttpStatus.OK).body(gameService.findById(id));
  }

  @PostMapping
  public ResponseEntity<GameModel> postGame(@Valid @RequestBody GameDTO dto) {
    GameModel game = gameService.create(dto);
    return ResponseEntity.status(HttpStatus.CREATED).body(game);
  }

}
