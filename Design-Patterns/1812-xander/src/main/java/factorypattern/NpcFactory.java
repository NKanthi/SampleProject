package factorypattern;

public class NpcFactory {

 private static NpcFactory instance = null;

 private NpcFactory() {}

  public static NpcFactory getInstance() {
    if (instance == null) {
      createInstance();
    }
    return instance;
  }

  private static void createInstance () {
    if(instance == null) {
      instance = new NpcFactory();
    }
  }

  public Npc getNpc(String npc) {
   switch (npc) {
     case "Terran": return new Terran();
     case "Protoss": return new Protoss();
     case "Zerg": return new Zerg();
   }
   return null;
  }

}
