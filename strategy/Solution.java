
// Client class
public class Solution {

    public static void main(String[] args) {

        ShoppingCart cart = new ShoppingCart();

        cart.setPaymentStrategy(new PayPalPayment("johndoe@example.com"));
        cart.checkout(100);
        
        cart.setPaymentStrategy(new CreditCardPayment("John Doe", "1234567890123456"));
        cart.checkout(200);
    }
}

// Strategy interface
interface PaymentStrategy {

    void pay(int amount);
}

// Concrete strategies
class CreditCardPayment implements PaymentStrategy {

    private String name;
    private String cardNumber;

    public CreditCardPayment(String name, String cardNumber) {

        this.name = name;
        this.cardNumber = cardNumber;
    }

    public void pay(int amount) {

        System.out.println("Payment of " + amount + " accepted using Credit Card!");
    }
}

class PayPalPayment implements PaymentStrategy {

    private String email;

    public PayPalPayment(String email) {

        this.email = email;
    }

    public void pay(int amount) {

        System.out.println("Payment of " + amount + " accepted using PayPal!");
    }
}

// Context
class ShoppingCart {

    private PaymentStrategy paymentStrategy;

    public void setPaymentStrategy(PaymentStrategy paymentStrategy) {

        this.paymentStrategy = paymentStrategy;
    }

    public void checkout(int amount) {

        paymentStrategy.pay(amount);
    }
}
