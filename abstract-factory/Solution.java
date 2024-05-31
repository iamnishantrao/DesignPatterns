import java.util.*;

// client class
public class Solution {

    public static void main(String[] args) {

        AbstractComboFactory comboOne = new ComboOneFactory();
        AbstractSandwich sandwichOne = comboOne.createSandwich();
        AbstractDrink drinkOne = comboOne.createDrink();
        AbstractSide sideOne = comboOne.createSide();
        System.out.println("Combo: " + sandwichOne.getCombo());
        System.out.println("Sandwich: " + sandwichOne.getName());
        System.out.println("Drink: " + drinkOne.getName());
        System.out.println("Side: " + sideOne.getName());

        System.out.println("-------------------------------------------------------------------------------------");

        AbstractComboFactory comboTwo = new ComboTwoFactory();
        AbstractSandwich sandwichTwo = comboTwo.createSandwich();
        AbstractDrink drinkTwo = comboTwo.createDrink();
        AbstractSide sideTwo = comboTwo.createSide();
        System.out.println("Combo: " + sandwichTwo.getCombo());
        System.out.println("Sandwich: " + sandwichOne.getName());
        System.out.println("Drink: " + drinkTwo.getName());
        System.out.println("Side: " + sideTwo.getName());
    }
}

// interface for abstract factory
interface AbstractComboFactory {

    public abstract AbstractSandwich createSandwich();

    public abstract AbstractDrink createDrink();

    public abstract AbstractSide createSide();
}

// concrete product classes
class ComboOneFactory implements AbstractComboFactory {

    public AbstractSandwich createSandwich() {

        return new SpicyChickenSandwich();
    }

    public AbstractDrink createDrink() {

        return new CocaCola();
    }

    public AbstractSide createSide() {

        return new SpicyFries();
    }
}

class ComboTwoFactory implements AbstractComboFactory {

    public AbstractSandwich createSandwich() {

        return new VegSandwich();
    }

    public AbstractDrink createDrink() {

        return new Pepsi();
    }

    public AbstractSide createSide() {

        return new NormalFries();
    }
}

// interfaces for different product types
interface AbstractSandwich {

    public abstract String getCombo();

    public abstract String getName();
}

interface AbstractDrink {

    public abstract String getName();
}

interface AbstractSide {

    public abstract String getName();
}

// concrete product classes
class SpicyChickenSandwich implements AbstractSandwich {

    public String getCombo() {
        
        return "You get a spicy Chicken Sandwich, Coca Cola, and Spicy Fries with this combo!";
    }

    public String getName() {
        
        return "Spicy Chicken Sandwich!";
    }
}

class CocaCola implements AbstractDrink {

    public String getName() {
        
        return "Coca Cola!";
    }
}

class SpicyFries implements AbstractSide {

    public String getName() {
        
        return "Spicy Fries!";
    }
}

class VegSandwich implements AbstractSandwich {

    public String getCombo() {
        
        return "You get a spicy Veg Sandwich, Pepsi, and Normal Fries with this combo!";
    }

    public String getName() {
        
        return "Veg Sandwich!";
    }
}

class Pepsi implements AbstractDrink {

    public String getName() {
        
        return "Pepsi!";
    }
}

class NormalFries implements AbstractSide {

    public String getName() {
        
        return "Normal Fries!";
    }
}
