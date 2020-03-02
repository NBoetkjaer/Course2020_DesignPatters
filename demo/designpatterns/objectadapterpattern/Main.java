package demo.designpatterns.objectadapterpattern;

import java.util.Date;

/*
 * This is the client code for the adapter pattern.
 */
public class Main {

    public static void main(String[] args) {
    	
        Logger logger1 = new GuiAdapter(new GuiMessager());
        doLog(logger1, "Hello World!");

        Logger logger2 = new FileAdapter(new FileLogger("MyLog.txt"));
        doLog(logger2, "Goodbye World at " + new Date());
    }

    // Most of the application down here...
    private static void doLog(Logger theLogger, String msg) {
    	theLogger.log(msg);
    }
}
