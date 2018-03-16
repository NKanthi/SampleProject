package templatemethodpattern;

public class GameServer extends ServerGeneralization {

  @Override
  boolean getData() {
    return authenticateUser() && getDataByUser();
  }

  @Override
  boolean loadData() {
    return loadDataByUser();
  }

  private boolean authenticateUser() {
    System.out.println("user auth");
    return true;
  }

  private boolean getDataByUser() {
    System.out.println("get user data");
    return true;
  }

  private boolean loadDataByUser() {
    System.out.println("Load user data");
    return true;
  }



}
