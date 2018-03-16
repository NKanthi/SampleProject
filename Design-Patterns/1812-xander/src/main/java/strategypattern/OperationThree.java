package strategypattern;

public class OperationThree implements Strategy {


  @Override
  public String doSomeThing(String string) {
    return string + "three";
  }
}
