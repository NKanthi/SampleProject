import java.io.File;

public class main {

  public static void main(String args[]) {
    File xmlToParse = new File("XML/phonelist.xml");
    Parser p = new Parser(xmlToParse);

    System.out.println(p.getPhoneSpecsListByModel("S88"));
    System.out.println(p.getPhoneSpecsListByModel("X5s"));
  }
}
