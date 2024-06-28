
// client class
public class Solution {

    public static void main(String[] args) {

        Text simpleText = new PlainText("Hello, Decorator Pattern!");
        System.out.println("Plain text: " + simpleText.getContent());

        Text boldText = new BoldTextDecorator(simpleText);
        System.out.println("Bold text: " + boldText.getContent());

        Text italicBoldText = new ItalicTextDecorator(boldText);
        System.out.println("Italic and bold text: " + italicBoldText.getContent());

        Text complexText = new UnderlineTextDecorator(italicBoldText);
        System.out.println("Complex formatted text: " + complexText.getContent());
    }
}

// Component interface
interface Text {

    String getContent();
}

// Concrete Component
class PlainText implements Text {

    private String content;

    public PlainText(String content) {

        this.content = content;
    }

    public String getContent() {

        return content;
    }
}

// Decorator
abstract class TextDecorator implements Text {

    protected Text decoratedText;

    public TextDecorator(Text decoratedText) {

        this.decoratedText = decoratedText;
    }

    public String getContent() {

        return decoratedText.getContent();
    }
}

// Concrete Decorators
class BoldTextDecorator extends TextDecorator {

    public BoldTextDecorator(Text decoratedText) {

        super(decoratedText);
    }

    public String getContent() {

        return "<b>" + super.getContent() + "</b>";
    }
}

class ItalicTextDecorator extends TextDecorator {

    public ItalicTextDecorator(Text decoratedText) {

        super(decoratedText);
    }

    public String getContent() {

        return "<i>" + super.getContent() + "</i>";
    }
}

class UnderlineTextDecorator extends TextDecorator {

    public UnderlineTextDecorator(Text decoratedText) {

        super(decoratedText);
    }

    public String getContent() {

        return "<u>" + super.getContent() + "</u>";
    }
}
