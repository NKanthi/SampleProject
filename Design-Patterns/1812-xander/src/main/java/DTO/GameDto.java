package DTO;

public class GameDto {
  private String title;
  private String ageRating;
  private int averageReviewScore;
  private int id;

  public GameDto(int id, String title, String ageRating, int averageReviewScore) {
    this.id = id;
    this.title = title;
    this.ageRating = ageRating;
    this.averageReviewScore = averageReviewScore;
  }

  public int getAverageReviewScore() {
    return averageReviewScore;
  }

  public void setAverageReviewScore(int averageReviewScore) {
    this.averageReviewScore = averageReviewScore;
  }

  public String getAgeRating() {
    return ageRating;
  }

  public void setAgeRating(String ageRating) {
    this.ageRating = ageRating;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public int getId() {
    return id;
  }

  @Override
  public String toString() {
    return title;
  }
}
