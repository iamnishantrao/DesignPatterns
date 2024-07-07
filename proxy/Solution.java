
// Client class
public class Solution {
    
    public static void main(String[] args) {
        
        Document userDocument = new SecureDocumentProxy("Confidential contents of the Document", "USER");
        Document adminDocument = new SecureDocumentProxy("Confidential contents of the Document", "ADMIN");

        System.out.println("User attempting to view confidential document:");
        userDocument.view();
        System.out.println("\nUser attempting to edit confidential document:");
        userDocument.edit();

        System.out.println("\nAdmin attempting to view confidential document:");
        adminDocument.view();
        System.out.println("\nAdmin attempting to edit confidential document:");
        adminDocument.edit();

    }
}

// Subject interface
interface Document {

    void view();
    void edit();
}

// Concrete Subject
class RealDocument implements Document {

    private String content;

    public RealDocument(String content) {

        this.content = content;
    }

    public void view() {

        System.out.println("Viewing document: " + content);
    }

    public void edit() {

        System.out.println("Editing document: " + content);
    }
}

// Proxy class
class SecureDocumentProxy implements Document {

    private RealDocument realDocument;
    private String userRole;

    public SecureDocumentProxy(String content, String userRole) {

        this.realDocument = new RealDocument(content);
        this.userRole = userRole;
    }

    public void view() {

        if (hasViewPermission()) {

            realDocument.view();
        } else {

            System.out.println("Access denied: You don't have permission to view this document.");
        }
    }

    public void edit() {

        if (hasEditPermission()) {

            realDocument.edit();
        } else {

            System.out.println("Access denied: You don't have permission to edit this document.");
        }
    }

    private boolean hasViewPermission() {

        return userRole.equals("USER") || userRole.equals("ADMIN");
    }

    private boolean hasEditPermission() {
        
        return userRole.equals("ADMIN");
    }
}
