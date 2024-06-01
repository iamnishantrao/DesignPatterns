import java.util.*;

// client class
public class Solution {
    
    public static void main(String[] args) {
        
        Director director = new Director();
        Builder builder = new BurgerBuilder();

        director.constructSinglePattyBurger(builder);
        System.out.println(builder.getBurger().toString());

        director.constructDoublePattyBurger(builder);
        System.out.println(builder.getBurger().toString());
    }
}

// the director class, this can also be done directly in the client code
class Director {

    public void constructSinglePattyBurger(Builder builder) {

        builder.reset();
        builder.addBuns();
        builder.addPatty(1);
        builder.addToppings(3);
        builder.addSauces(3);
    }

    public void constructDoublePattyBurger(Builder builder) {

        builder.reset();
        builder.addBuns();
        builder.addPatty(2);
        builder.addToppings(2);
        builder.addSauces(2);
    }
}

// builder interface declaring the steps for creating an object
interface Builder {

    public abstract void addBuns();
    public abstract void addPatty(int count);
    public abstract void addToppings(int count);
    public abstract void addSauces(int count);

    public abstract void reset();
    public abstract Burger getBurger();
}

// concrete implementation of the Builder interface
class BurgerBuilder implements Builder {

    private Burger burger;

    public BurgerBuilder() {

        reset();
    }

    public void addBuns() {

        burger.addIngredient("2 Buns");
    }

    public void addPatty(int count) {
        
        burger.addIngredient(count + " patties");
    }

    public void addToppings(int count) {

        burger.addIngredient(count + " toppings");
    }

    public void addSauces(int count) {

        burger.addIngredient(count + " sauces");
    }

    public void reset() {

        burger = new Burger();
    }

    public Burger getBurger() {

        return burger;
    }
}

// the product whose object we will get from Builder
class Burger {

    private List<String> ingredients = new ArrayList<>();

    public void addIngredient(String ingredient) {
        
        ingredients.add(ingredient);
    }

    public String toString() {
        
        return "Your burger have the following items: " + Arrays.toString(ingredients.toArray());
    }
}
