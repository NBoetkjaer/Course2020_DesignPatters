package demo.designpatterns.objectadapterpattern;

/*
 * This is one of the Adapter classes in the adapter pattern.
 */
public class FileAdapter implements Logger {

    private FileLogger adaptee;

    public FileAdapter(FileLogger l) {
        adaptee = l;
    }

    public void log(String message) {
        adaptee.appendMessage(message);
    }
}
