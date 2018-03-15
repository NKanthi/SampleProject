package DAO;

import DTO.GameDTO;

import java.util.ArrayList;
import java.util.List;

public class GameDAO {
  private List<GameDTO> gameDB = new ArrayList<>(); //pretend this is a database

  public GameDAO() {
    gameDB.add(new GameDTO(1,"Bioshock","M",8));
    gameDB.add(new GameDTO(2,"Nier","A",8));
    gameDB.add(new GameDTO(3,"World of Warcraft","M",7));
    gameDB.add(new GameDTO(4,"Stardew Valley","E",9));
    gameDB.add(new GameDTO(5,"Sims 4","E",6));
    gameDB.add(new GameDTO(6,"Terraria","E",8));
  }

  public List<GameDTO> getAllGames() {
    List<GameDTO> games = new ArrayList<>(gameDB);
    return games;
  }

  public List<GameDTO> getGamesByAverageReviewScore(int score) {
    List<GameDTO> games = new ArrayList<>();
    for(GameDTO game : gameDB ) {
      if(score == game.getAverageReviewScore()) {
        games.add(game);
      }
    }
    return games;
  }

  public GameDTO getGameByTitle(String title) {
    for(GameDTO game : gameDB ) {
      if(title.equals(game.getTitle())) {
        return game;
      }
    }
    return null;
  }

  public List<GameDTO> getGamesByAgeRating(String ageRating) {
    List<GameDTO> games = new ArrayList<>();
    for(GameDTO game : gameDB ) {
      if(ageRating.equals(game.getAgeRating())) {
        games.add(game);
      }
    }
    return games;
  }

  public GameDTO getGameByID(int id) {
    for(GameDTO game : gameDB ) {
      if(id == game.getId()) {
        return game;
      }
    }
    return null;
  }




}
