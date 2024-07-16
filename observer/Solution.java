import java.util.List;
import java.util.ArrayList;

// Client class
public class Solution {

    public static void main(String[] args) {

        SocialMediaFeed feed = new SocialMediaFeed();

        User user1 = new User("Alice");
        User user2 = new User("Bob");
        User user3 = new User("Charlie");

        feed.addObserver(user1);
        feed.addObserver(user2);
        feed.addObserver(user3);

        feed.addPost("David", "Hello, world!");
        System.out.println();
        feed.addPost("John", "How are you guys?");
    }
}

// Subject
class SocialMediaFeed {

    private String post;
    private String username;
    private List<NotificationObserver> observers = new ArrayList<>();

    public void addObserver(NotificationObserver observer) {

        observers.add(observer);
    }

    public void removeObserver(NotificationObserver observer) {

        observers.remove(observer);
    }

    public void addPost(String username, String post) {

        System.out.println(username + " posted a new post -> (" + post + ")\n");
        this.username = username;
        this.post = post;
        notifyObservers();
    }

    private void notifyObservers() {

        for (NotificationObserver observer : observers) {

            observer.update(username, post);
        }
    }
}

// Observer Interface
interface NotificationObserver {

    void update(String username, String post);
}

// Concrete Observer
class User implements NotificationObserver {

    private String name;

    public User(String name) {

        this.name = name;
    }

    public void update(String username, String post) {

        System.out.println(name + " received notification: " + post + " (from " + username + ")");
    }
}
