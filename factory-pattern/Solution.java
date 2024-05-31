import java.util.*;

public class Solution {

    public static void main(String[] args) {

        List<Creator> creators = new ArrayList<>();
        creators.add(new FirstConcreteCreator());
        creators.add(new SecondConcreteCreator());

        for (Creator creator : creators) {

            Product product = creator.FactoryMethod();
            System.out.println("Created product of type: " + product.getClass());
            product.sayHello();
        }
    }
}

// abstract Product class which can be extended by any new products
abstract class Product {

    public abstract void sayHello();
}

// concrete implementations of the Product class
class FirstConcreteProduct extends Product {

    public void sayHello() {

        System.out.println("Hello from First Concrete Product class!");
    }
}

class SecondConcreteProduct extends Product {

    public void sayHello() {

        System.out.println("Hello from Second Concrete Product class!");
    }
}

// creator which would provide the abstract factory method
// we can define it as an abstract class if we want some methods to provide some basic
// functionality, or make it an interface if we want method definitions only
interface Creator {

    public abstract Product FactoryMethod();
}

// concrete creator class for first product
class FirstConcreteCreator implements Creator {

    public Product FactoryMethod() {

        return new FirstConcreteProduct();
    }

}

// concrete creator class for second product
class SecondConcreteCreator implements Creator {

    public Product FactoryMethod() {

        return new SecondConcreteProduct();
    }
}
