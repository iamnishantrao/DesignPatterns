import java.util.*;

// Client class
public class Solution {

    public static void main(String[] args) {

        Directory root = new Directory("root");
        Directory music = new Directory("music");
        Directory documents = new Directory("documents");

        root.addElement(music);
        root.addElement(documents);

        music.addElement(new File("song1.mp3"));
        music.addElement(new File("song2.mp3"));

        documents.addElement(new File("document1.doc"));
        documents.addElement(new File("document2.doc"));

        TotalNumberOfFilesVisitor totalNumberOfFilesVisitor = new TotalNumberOfFilesVisitor();
        root.accept(totalNumberOfFilesVisitor);

        System.out.println("Total number of files: " + totalNumberOfFilesVisitor.getNumberOfFiles());

        TotalSizeVisitor totalSizeVisitor = new TotalSizeVisitor();

        music.accept(totalSizeVisitor);
        System.out.println("Total size of music files: " + totalSizeVisitor.getTotalSize());

        totalSizeVisitor = new TotalSizeVisitor();
        documents.accept(totalSizeVisitor);
        System.out.println("Total size of document files: " + totalSizeVisitor.getTotalSize());

        totalSizeVisitor = new TotalSizeVisitor();
        root.accept(totalSizeVisitor);
        System.out.println("Total size of the root directory: " + totalSizeVisitor.getTotalSize());
    }
}

// Element interface
interface FileSystemElement {

    void accept(Visitor visitor);
}

// Concrete Elements
class File implements FileSystemElement {

    private String name;
    private String format;

    public File(String name) {

        this.name = name;

        if (name.contains(".mp3")) {
            this.format = ".mp3";
        } else {
            this.format = ".doc";
        }
    }

    public String getName() {

        return name;
    }

    public String getFormat() {

        return format;
    }

    public void accept(Visitor visitor) {

        visitor.visit(this);
    }
}

class Directory implements FileSystemElement {

    private String name;

    private List<FileSystemElement> elements = new ArrayList<>();

    public Directory(String name) {

        this.name = name;
    }

    public String getName() {

        return name;
    }

    public void addElement(FileSystemElement element) {

        elements.add(element);
    }

    public void accept(Visitor visitor) {

        visitor.visit(this);

        for (FileSystemElement element : elements) {

            element.accept(visitor);
        }
    }
}

// Visitor interface
interface Visitor {

    void visit(File file);
    void visit(Directory directory);
}

// Concrete Visitors
class TotalNumberOfFilesVisitor implements Visitor {

    private int numberOfFiles = 0;

    public void visit(File file) {

        numberOfFiles += 1;
    }

    public void visit(Directory directory) {

        
    }

    public int getNumberOfFiles() {

        return numberOfFiles;
    }
}

class TotalSizeVisitor implements Visitor {

    private int totalSize = 0;

    public void visit(File file) {

        if (file.getFormat().equals(".mp3")) {
            totalSize +=3;
        } else {
            totalSize += 1;
        }
    }

    public void visit(Directory directory) {

    }

    public int getTotalSize() {

        return totalSize;
    }
}
