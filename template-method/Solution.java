import java.util.*;

// Client class
public class Solution {

    public static void main(String[] args) {

        System.out.println("-----Processing PDF Document-----");
        DocumentProcessor pdfProcessor = new PDFProcessor();
        pdfProcessor.processDocument("sample.pdf");

        System.out.println("\n-----Processing Word Document-----");
        DocumentProcessor wordProcessor = new WordProcessor();
        wordProcessor.processDocument("sample.docx");
    }
}

// Abstract Class
abstract class DocumentProcessor {

    // Template method
    public final void processDocument(String filePath) {

        openDocument(filePath);
        String content = extractText();
        List<String> words = parseContent(content);
        int wordCount = countWords(words);
        displayResults(wordCount);
        closeDocument();
    }

    // Abstract Methods
    protected abstract void openDocument(String filePath);
    protected abstract String extractText();
    protected abstract void closeDocument();

    // Common Methods
    protected List<String> parseContent(String content) {

        System.out.println("Parsing content into words...");

        return Arrays.asList(content.split("\\s+"));
    }

    protected int countWords(List<String> words) {

        System.out.println("Counting words...");
        return words.size();
    }

    protected void displayResults(int wordCount) {

        System.out.println("Total words: " + wordCount);
    }
}

// Concrete Classes
class PDFProcessor extends DocumentProcessor {

    protected void openDocument(String filePath) {

        System.out.println("Opening PDF document: " + filePath);
    }

    protected String extractText() {

        String contents = "This is a sample PDF content with some text to process.";
        System.out.println("Extracting text from PDF document...");
        System.out.println("Contents of PDF document: " + contents);

        return contents;
    }

    protected void closeDocument() {

        System.out.println("Closing PDF document...");
    }
}

class WordProcessor extends DocumentProcessor {

    protected void openDocument(String filePath) {

        System.out.println("Opening Word document: " + filePath);
    }

    protected String extractText() {

        String contents = "This is a sample Word document content with some more text to process.";
        System.out.println("Extracting text from Word document...");
        System.out.println("Contents of Word document: " + contents);

        return contents;
    }

    protected void closeDocument() {

        System.out.println("Closing Word document...");
    }

    protected List<String> parseContent(String content) {

        System.out.println("Parsing content into words (ignoring 'a' and 'the')");
        
        List<String> allWords = super.parseContent(content);
        List<String> filteredWords = new ArrayList<>();
        
        for (String word : allWords) {
            
            if (!word.equalsIgnoreCase("a") && !word.equalsIgnoreCase("the")) {
                filteredWords.add(word);
            }
        }

        return filteredWords;
    }
}
