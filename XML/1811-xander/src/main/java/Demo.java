import java.io.File;


public class Demo {

  public static void main(String args[]) {
    File xmlToParse = new File(Constants.PHONE_LIST_LOCATION);
    Parser p = new Parser(xmlToParse);

    System.out.println(p.getPhoneSpecsListByModel("S88"));
    System.out.println(p.getPhoneSpecsListByModel("X5s"));
  }
}
