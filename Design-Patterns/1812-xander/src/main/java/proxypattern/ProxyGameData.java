package proxypattern;

public class ProxyGameData implements Data {
  private GameData gameData;
  private String dataPath;

  public ProxyGameData(String dataPath) {
    this.dataPath = dataPath;
  }

  @Override
  public void getData() {
    if(gameData == null) {
      gameData = new GameData(dataPath);
    }
    gameData.getData();
  }
}
