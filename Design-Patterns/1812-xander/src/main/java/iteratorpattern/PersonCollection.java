package iteratorpattern;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PersonCollection implements Container {

  private List<Person> people = new ArrayList<Person>();

  public void add(Person... p) {
    Collections.addAll(people, p);
  }

  public Iterator getIterator() {
    return new PersonIterator();
  }

  private class PersonIterator implements Iterator {

    int index;

    public boolean hasNext() {
      return index < people.toArray().length;
    }

    public Person next() {
      if(this.hasNext()) {
        return people.get(index++);
      }
      return null;
    }

  }

}
