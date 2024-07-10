import java.util.Queue;
import java.util.LinkedList;

// Client
public class Solution {
    public static void main(String[] args) {

        JobQueue jobQueue = new JobQueue();
        
        EmailService emailService = new EmailService();
        PrintService printService = new PrintService();

        jobQueue.addJob(new EmailJob("hello@abcd.com", emailService));
        jobQueue.addJob(new PrintJob("Commands.pdf", printService));
        jobQueue.addJob(new EmailJob("world@abcd.com", emailService));
        jobQueue.addJob(new PrintJob("Report.docx", printService));

        jobQueue.processJobs();
    }
}

// Command interface
interface Job {

    void execute();
}

// Concrete Commands
class EmailJob implements Job {

    private String to;
    private EmailService emailService;

    public EmailJob(String to, EmailService emailService) {

        this.to = to;
        this.emailService = emailService;
    }

    public void execute() {

        emailService.sendEmail(to);
    }
}

class PrintJob implements Job {

    private String document;
    private PrintService printService;

    public PrintJob(String document, PrintService printService) {

        this.document = document;
        this.printService = printService;
    }

    public void execute() {

        printService.printDocument(document);
    }
}

// Receivers
class EmailService {

    public void sendEmail(String to) {

        System.out.println("----------EmailService----------");
        System.out.println("Sending email to: " + to);
        System.out.println();
    }
}

class PrintService {

    public void printDocument(String document) {

        System.out.println("----------PrintService----------");
        System.out.println("Printing document: " + document);
        System.out.println();
    }
}

// Invoker
class JobQueue {

    private Queue<Job> jobs = new LinkedList<>();

    public void addJob(Job job) {

        jobs.offer(job);
    }

    public void processJobs() {

        while (!jobs.isEmpty()) {
            Job job = jobs.poll();
            job.execute();
        }
    }
}
