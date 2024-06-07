import java.util.*;

// client class
public class Solution {

    public static void main(String[] args) {
        
        Box pencilBox = new Box();
        pencilBox.addProduct(new Product("pencil", 2));
        pencilBox.addProduct(new Product("pen", 5));
        pencilBox.addProduct(new Product("eraser", 1));

        System.out.println("Total price of items in pencil box: " + pencilBox.getPrice());

        Box bag = new Box();
        bag.addProduct(pencilBox);
        bag.addProduct(new Product("design patterns", 5));

        System.out.println("Total price of items in bag: " + bag.getPrice());
    }
}

// component interface
interface Item {

    public int getPrice();
}

// leaf class
class Product implements Item {

    public String name;
    public int price;

    public Product(String name, int price) {

        this.name = name;
        this.price = price;
    }

    public int getPrice() {

        return price;
    }
}

// composite class
class Box implements Item {

    public List<Item> contents = new ArrayList<>();

    public Box() {

    }

    public void addProduct(Item item) {

        contents.add(item);
    }

    public int getPrice() {

        int totalPrice = 0;
        for (Item item : contents) {

            totalPrice += item.getPrice();
        }

        return totalPrice;
    }
}
