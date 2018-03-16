package templatemethodpattern;

public class BoringServer extends ServerGeneralization {
  @Override
  boolean getData() {
    System.out.println("Getting data");
    return false;
  }

  @Override
  boolean loadData() {
    System.out.println("Loading data");
    return false;
  }
}
