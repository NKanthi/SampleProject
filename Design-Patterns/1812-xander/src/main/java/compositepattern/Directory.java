package compositepattern;

import java.util.ArrayList;
import java.util.List;

public class Directory implements FileInterface {

  private String name;

  List<FileInterface> savedFiles = new ArrayList<>();

  public Directory(String name) {
    this.name = name;
  }

  @Override
  public void list() {
    System.out.println(this.getName());
    for (FileInterface file : savedFiles) {
      file.list();
    }
  }

  public void add(FileInterface file) {
    savedFiles.add(file);
  }


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}
