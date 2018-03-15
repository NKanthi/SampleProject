package strategypattern;

public class Context {
  private Strategy strategy;

  public Context(Strategy strategy) {
    this.strategy = strategy;
  }

  public String executeStrategy(String string) {
    return strategy.doSomeThing(string);
  }

}
