// client class
public class Solution {
    
    public static void main(String[] args) {
        
        DatabaseConnection connection1 = DatabaseConnection.getInstance();
        DatabaseConnection connection2 = DatabaseConnection.getInstance();
        System.out.println("Two objects are the same: " + connection1.equals(connection2));
        System.out.println("Connection 1: " + connection1.toString() + "\nConnection 2: " + connection2.toString());
    }
}

// the singleton class which would only have a single instance
class DatabaseConnection {

    private static DatabaseConnection databaseConnection;

    private DatabaseConnection() {

    }

    // method to return the only instance of the class
    public static DatabaseConnection getInstance() {

        if (databaseConnection == null) {
            databaseConnection = new DatabaseConnection();
        }

        return databaseConnection;
    }
}
