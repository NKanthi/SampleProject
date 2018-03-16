package proxypattern;

public class GameData implements Data {
  private String dataPath;

  public GameData(String dataPath) {
    this.dataPath = dataPath;
    loadData();
  }

  @Override
  public void getData() {
    System.out.println(dataPath);
  }

  public void loadData() {
    System.out.println("Loading Data from" + dataPath);
  }
}
