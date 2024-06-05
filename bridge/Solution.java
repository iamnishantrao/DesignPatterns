
// client class
public class Solution {

    public static void main(String[] args) {
        
        Shape rectangle = new Rectangle(new Green());
        rectangle.draw();

        System.out.println("------------------------");

        Shape circle = new Circle(new Red());
        circle.draw();
    }
}

// abstraction
abstract class Shape {

    protected Color color;

    public Shape(Color color) {

        this.color = color;
    }

    public abstract void draw();
}

// refined abstractions
class Rectangle extends Shape {

    public Rectangle(Color color) {
        
        super(color);
    }

    public void draw() {

        System.out.println("Drawing a Rectangle!");
        color.fillColor();
    }
}

// refined abstraction
class Circle extends Shape {

    public Circle(Color color) {
        
        super(color);
    }

    public void draw() {

        System.out.println("Drawing a Circle!");
        color.fillColor();
    }
}

// implementor
interface Color {

    public void fillColor();
}

// concrete implementor
class Green implements Color {

    public void fillColor() {

        System.out.println("Filling Green Color!");
    }
}

// concrete implementor
class Red implements Color {

    public void fillColor() {

        System.out.println("Filling Red Color!");
    }
}
