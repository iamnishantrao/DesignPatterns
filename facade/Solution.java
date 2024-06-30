
// client
public class Solution {

    public static void main(String[] args) {

        ReceptionistFacade receptionist = new ReceptionistFacade();
        receptionist.welcomeNewEmployee("John Doe", "Remote");

        System.out.println("\n--------------------------------------\n");

        receptionist.welcomeNewEmployee("Jane Doe", "In Person");
    }
}

// Facade
class ReceptionistFacade {

    private HumanResources humanResources;
    private ITDepartment itDepartment;
    private SecurityOffice security;

    public ReceptionistFacade() {

        this.humanResources = new HumanResources();
        this.itDepartment = new ITDepartment();
        this.security = new SecurityOffice();
    }

    public void welcomeNewEmployee(String name, String workEnvironment) {
        
        humanResources.onboardNewEmployee(name);
        if (workEnvironment.equals("Remote")) {
            itDepartment.setupLaptop(name);
        } else {
            itDepartment.setupDesktop(name);
        }
        security.issueKeycard(name);

        System.out.println("Receptionist: " + name + " is onboarded!");
    }
}

// Subsystem classes
class HumanResources {

    public void onboardNewEmployee(String name) {

        System.out.println("HR: Onboarding new employee " + name);
    }
}

class ITDepartment {

    public void setupDesktop(String name) {

        System.out.println("IT: Setting up desktop for " + name);
    }

    public void setupLaptop(String name) {

        System.out.println("IT: Setting up laptop for " + name);
    }
}

class SecurityOffice {

    public void issueKeycard(String name) {

        System.out.println("Security: Issuing keycard to " + name);
    }
}
