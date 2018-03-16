package DAO;

import DTO.GameDto;

import java.util.ArrayList;
import java.util.List;

public class GameDao {
  private List<GameDto> gameDb = new ArrayList<>(); //pretend this is a database

  public GameDao() {
    gameDb.add(new GameDto(1,"Bioshock","M",8));
    gameDb.add(new GameDto(2,"Nier","A",8));
    gameDb.add(new GameDto(3,"World of Warcraft","M",7));
    gameDb.add(new GameDto(4,"Stardew Valley","E",9));
    gameDb.add(new GameDto(5,"Sims 4","E",6));
    gameDb.add(new GameDto(6,"Terraria","E",8));
  }

  public List<GameDto> getAllGames() {
    List<GameDto> games = new ArrayList<>(gameDb);
    return games;
  }

  public List<GameDto> getGamesByAverageReviewScore(int score) {
    List<GameDto> games = new ArrayList<>();
    for (GameDto game : gameDb) {
      if (score == game.getAverageReviewScore()) {
        games.add(game);
      }
    }
    return games;
  }

  public GameDto getGameByTitle(String title) {
    for (GameDto game : gameDb) {
      if (title.equals(game.getTitle())) {
        return game;
      }
    }
    return null;
  }

  public List<GameDto> getGamesByAgeRating(String ageRating) {
    List<GameDto> games = new ArrayList<>();
    for (GameDto game : gameDb) {
      if (ageRating.equals(game.getAgeRating())) {
        games.add(game);
      }
    }
    return games;
  }

  public GameDto getGameByID(int id) {
    for (GameDto game : gameDb) {
      if (id == game.getId()) {
        return game;
      }
    }
    return null;
  }




}
