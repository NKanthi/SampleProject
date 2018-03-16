import DAO.GameDAO;
import DTO.GameDTO;
import compositepattern.Directory;
import compositepattern.File;
import factorypattern.Npc;
import factorypattern.NpcFactory;
import iteratorpattern.Iterator;
import iteratorpattern.Person;
import iteratorpattern.PersonCollection;
import observerpattern.Message;
import observerpattern.MessageSubscriber;
import observerpattern.Observer;
import strategypattern.Context;
import strategypattern.OperationOne;
import strategypattern.OperationThree;
import strategypattern.OperationTwo;
import templatemethodpattern.BoringServer;
import templatemethodpattern.GameServer;
import templatemethodpattern.ServerGeneralization;

import java.util.ArrayList;
import java.util.List;

public class Demo {
  private final static String BREAK_LINE = System.lineSeparator();

  public static void main(String args[]) {
    Demo d = new Demo();

    d.observerPattern();
    System.out.print(BREAK_LINE);

    d.iteratorPattern();
    System.out.print(BREAK_LINE);

    d.templateMethodPattern();
    System.out.print(BREAK_LINE);

    d.strategyPattern();
    System.out.println(BREAK_LINE);

    d.factoryPattern();
    System.out.println(BREAK_LINE);

    d.DAOandDTO();
    System.out.println(BREAK_LINE);

    d.compositePattern();
    System.out.println(BREAK_LINE);
  }


  private void observerPattern() {
    Message message = new Message();

    Observer messageSubscriber1 = new MessageSubscriber("msg1");
    Observer messageSubscriber2 = new MessageSubscriber("msg2");
    Observer messageSubscriber3 = new MessageSubscriber("msg3");

    message.register(messageSubscriber1);
    message.register(messageSubscriber2);
    message.register(messageSubscriber3);

    messageSubscriber1.setSubject(message);
    messageSubscriber2.setSubject(message);
    messageSubscriber3.setSubject(message);

    messageSubscriber1.update();

    message.postMessage("test");

  }

  private void iteratorPattern() {
    PersonCollection personCollection = new PersonCollection();
    personCollection.add(new Person("Xander", "dev"), new Person("Haoran", "Datascience"));

    for(Iterator iter = personCollection.getIterator(); iter.hasNext();) {
      Person person = (Person)iter.next();
      String name = person.getName();
      String occupation = person.getOccupation();

      System.out.println("name:" + name + " " + "Occupation:" + occupation);
    }

  }

  private void templateMethodPattern() {
    ServerGeneralization gs = new GameServer();
    gs.spinUp();

    System.out.println(BREAK_LINE);

    ServerGeneralization bs = new BoringServer();
    bs.spinUp();
  }

  private void strategyPattern() {
    Context context = new Context(new OperationOne());
    System.out.println(context.executeStrategy("test"));

    context = new Context(new OperationTwo());
    System.out.println(context.executeStrategy("test"));

    context = new Context(new OperationThree());
    System.out.println(context.executeStrategy("test"));
  }

  private void factoryPattern() {
    List<Npc> npcList = new ArrayList<>();

    NpcFactory nf = NpcFactory.getInstance();

    npcList.add(nf.getNpc("Terran"));
    npcList.add(nf.getNpc("Protoss"));
    npcList.add(nf.getNpc("Zerg"));

    npcList.forEach(Npc::printRace);
  }

  private void DAOandDTO() {
    GameDAO gameDAO = new GameDAO();

    System.out.println(gameDAO.getAllGames());

    System.out.println(gameDAO.getGameByID(1));

    GameDTO stardewValley = gameDAO.getGameByTitle("Stardew Valley");

    System.out.println(stardewValley);
  }

  private void compositePattern() {
    Directory secret = new Directory("SECRET");
    Directory totallySafe = new Directory("TOTALLYSAFE");

    totallySafe.add(new File("oranges"));
    totallySafe.add(new File("apples"));
    totallySafe.add(new File("melons"));
    totallySafe.add(new File("grapes"));

    secret.add(new File("euro"));
    secret.add(new File("yen"));
    secret.add(new File("dollar"));
    secret.add(new File("crowns"));

    secret.add(totallySafe);


    secret.list();




  }
}
