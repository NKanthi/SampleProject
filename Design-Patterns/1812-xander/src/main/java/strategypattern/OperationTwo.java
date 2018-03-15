package strategypattern;

public class OperationTwo implements Strategy {

  @Override
  public String doSomeThing(String string) {
    return string+"two";
  }
}
