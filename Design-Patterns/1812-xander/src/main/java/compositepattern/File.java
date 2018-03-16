package compositepattern;

public class File implements FileInterface {
  private String name;

  public File(String name) {
    this.name = name;
  }

  @Override
  public void list() {
    System.out.println(this.getName());
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}
