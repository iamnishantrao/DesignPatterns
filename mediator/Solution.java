import java.util.List;
import java.util.ArrayList;

// Client class
public class Solution {

    public static void main(String[] args) {
        
        ChatMediator chatroom = new ChatRoom();

        User john = new ChatUser(chatroom, "John");
        User alice = new ChatUser(chatroom, "Alice");
        User bob = new ChatUser(chatroom, "Bob");

        chatroom.addUser(john);
        chatroom.addUser(alice);
        chatroom.addUser(bob);

        john.send("Hello everyone!");
        System.out.println();
        alice.send("Hi John, how are you?");
        System.out.println();
        bob.send("Hey guys, what's up?");
    }
}

// Mediator interface
interface ChatMediator {

    void sendMessage(String message, User user);
    void addUser(User user);
}

// Concrete Mediator
class ChatRoom implements ChatMediator {

    private List<User> users;

    public ChatRoom() {

        this.users = new ArrayList<>();
    }

    public void addUser(User user) {

        this.users.add(user);
    }

    public void sendMessage(String message, User user) {

        for (User u : this.users) {

            if (u != user) {
                u.receive(message);
            }
        }
    }
}

// Colleague
abstract class User {

    protected String name;
    protected ChatMediator mediator;

    public User(ChatMediator mediator, String name) {

        this.mediator = mediator;
        this.name = name;
    }

    public abstract void send(String message);
    public abstract void receive(String message);
}

// Concrete Colleague
class ChatUser extends User {

    public ChatUser(ChatMediator mediator, String name) {

        super(mediator, name);
    }

    public void send(String message) {

        System.out.println(this.name + " sending: " + message);
        mediator.sendMessage(message, this);
    }

    public void receive(String message) {

        System.out.println(this.name + " received: " + message);
    }
}
