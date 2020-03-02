package demo.designpatterns.objectadapterpattern;

/*
 * This is one of the Adapter classes in the adapter pattern.
 */
public class GuiAdapter implements Logger {

    private GuiMessager adaptee;

    public GuiAdapter(GuiMessager g) {
        adaptee = g;
    }

    public void log(String message) {
        adaptee.displayInfoMessage(message);
    }
}
