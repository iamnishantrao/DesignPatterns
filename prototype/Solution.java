import java.util.*;

public class Solution {

    public static void main(String[] args) {
        
        // initial burger prototype
        VegBurger burger = new VegBurger();
        burger.addTopping("Buns");
        burger.addTopping("Tomato");
        burger.addTopping("Onions");
        burger.addTopping("Mustard Sauce");
        System.out.println("Original Burger - " + burger.toString());

        // cloned veg burger
        VegBurger clonVegBurger = (VegBurger) burger.clone();
        clonVegBurger.addTopping("Cheese Slice");
        clonVegBurger.addTopping("Hash Browns on Side");
        System.out.println("Cloned Veg Burger - " + clonVegBurger.toString());
    }
}

// the prototype class
abstract class Burger {

    public abstract Burger clone();
}

// concrete implementation of prototype
class VegBurger extends Burger {

    public List<String> toppings;

    public VegBurger() {

        toppings = new ArrayList<>();
    }

    public VegBurger(List<String> toppings) {

        this.toppings = toppings;
    }

    public void addTopping(String topping) {

        toppings.add(topping);
    }

    public Burger clone() {

        return new VegBurger(new ArrayList<>(toppings));
    }

    public String toString() {

        return "Burger Toppings: " + Arrays.toString(toppings.toArray());
    }
}

