package templatemethodpattern;

public abstract class ServerGeneralization {
  public void spinUp() {
    if (bootServer() && getData() && loadData()) {
      System.out.println("Server ready");
    } else {
      System.out.println("Server failure");
    }

    if(shutdown()) {
      System.out.println("Server shutdown complete");
    }
  }

   boolean bootServer() {
    System.out.println("Server booting");
    return true;
   }

  abstract boolean getData();

  abstract boolean loadData();

   boolean shutdown() {
    System.out.println("Server shutting down");
    return true;
  }
}
