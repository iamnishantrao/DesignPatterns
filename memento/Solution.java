import java.util.Stack;

// Client class
public class Solution {
    
    public static void main(String[] args) {
        
        TextEditor editor = new TextEditor();
        TextEditorHistory history = new TextEditorHistory();

        editor.addText("Hello, ");
        history.push(editor.save());

        editor.addText("world!");
        history.push(editor.save());

        editor.addText(" How are you?");

        editor.restore(history.pop());
        System.out.println("After first restore: " + editor.getCurrentText());

        editor.restore(history.pop());
        System.out.println("After second undo: " + editor.getCurrentText());

    }
}

// Memento class
class TextEditorMemento {

    private final String text;

    public TextEditorMemento(String text) {

        this.text = text;
    }

    public String getText() {

        return text;
    }
}

// Originator class
class TextEditor {

    private StringBuilder currentText;


    public TextEditor() {

        this.currentText = new StringBuilder();
    }

    public void addText(String text) {

        currentText.append(text);
        System.out.println("Current State: " + currentText);
    }

    public String getCurrentText() {

        return currentText.toString();
    }

    public TextEditorMemento save() {

        System.out.println("Saving State...\n");
        return new TextEditorMemento(currentText.toString());
    }

    public void restore(TextEditorMemento memento) {

        System.out.println("\nRestoring State...");
        this.currentText = new StringBuilder(memento.getText());
    }
}

// Caretaker class
class TextEditorHistory {

    private final Stack<TextEditorMemento> history = new Stack<>();

    public void push(TextEditorMemento memento) {

        history.push(memento);
    }

    public TextEditorMemento pop() {

        if (!history.isEmpty()) {
            return history.pop();
        }

        return null;
    }
}
