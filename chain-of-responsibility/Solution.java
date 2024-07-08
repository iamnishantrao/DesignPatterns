
public class Solution {
    
    public static void main(String[] args) {

        Logger loggerChain = getChainOfLoggers();
        
        loggerChain.logMessage(Logger.INFO, "This is an information.");
        System.out.println();

        loggerChain.logMessage(Logger.DEBUG, "This is a debug level information.");
        System.out.println();

        loggerChain.logMessage(Logger.ERROR, "This is an error information.");
    }

    private static Logger getChainOfLoggers() {
        
        Logger errorLogger = new EmailLogger(Logger.ERROR);
        Logger fileLogger = new FileLogger(Logger.DEBUG);
        Logger consoleLogger = new ConsoleLogger(Logger.INFO);
        
        errorLogger.setNextLogger(fileLogger);
        fileLogger.setNextLogger(consoleLogger);
        
        return errorLogger;
    }
}

// Handler
abstract class Logger {
    
    public static int INFO = 1;
    public static int DEBUG = 2;
    public static int ERROR = 3;
    
    protected int level;
    protected Logger nextLogger;
    
    public void setNextLogger(Logger nextLogger) {

        this.nextLogger = nextLogger;
    }
    
    public void logMessage(int level, String message) {

        if (this.level <= level) {

            write(message);
        }

        if (nextLogger != null) {

            nextLogger.logMessage(level, message);
        }
    }
    
    protected abstract void write(String message);
}

// Concrete Handlers
class ConsoleLogger extends Logger {

    public ConsoleLogger(int level) {

        this.level = level;
    }
    
    protected void write(String message) {

        System.out.println("Standard Console:: Logger: " + message);
    }
}

class FileLogger extends Logger {

    public FileLogger(int level) {

        this.level = level;
    }
    
    protected void write(String message) {

        System.out.println("File:: Logger: " + message);
    }
}

class EmailLogger extends Logger {

    public EmailLogger(int level) {

        this.level = level;
    }
    
    protected void write(String message) {
        
        System.out.println("Email:: Logger: " + message);
    }
}
