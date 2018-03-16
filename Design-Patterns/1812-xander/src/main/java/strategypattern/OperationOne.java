package strategypattern;

public class OperationOne implements Strategy {

  @Override
  public String doSomeThing(String string) {
    return string + "one";
  }
}
