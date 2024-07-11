import java.util.List;
import java.util.ArrayList;

// Client class
public class Solution {
    public static void main(String[] args) {

        Aggregate aggregate = new ConcreteAggregate();
        aggregate.addItem("Item 1");
        aggregate.addItem("Item 2");
        aggregate.addItem("Item 3");
        aggregate.addItem("Item 4");
        aggregate.addItem("Item 5");

        Iterator iterator = aggregate.createIterator();

        System.out.println("Iterating over the items in aggregate!");

        while (iterator.hasNext()) {

            System.out.println(iterator.next());
        }

        System.out.println("Done iterating!");
    }
}

// Iterator interface
interface Iterator {

    boolean hasNext();

    String next();
}

// Concrete Iterator
class ConcreteIterator implements Iterator {

    private int position = 0;
    private List<String> items;

    public ConcreteIterator(List<String> items) {

        this.items = items;
    }

    public boolean hasNext() {

        return position < items.size();
    }

    public String next() {

        if (this.hasNext()) {

            return items.get(position++);
        }

        return null;
    }
}

// Aggregate interface
interface Aggregate {

    void addItem(String item);

    Iterator createIterator();
}

// Concrete Aggregate
class ConcreteAggregate implements Aggregate {

    private List<String> items = new ArrayList<>();

    public void addItem(String item) {

        items.add(item);
    }

    public Iterator createIterator() {

        return new ConcreteIterator(items);
    }
}
