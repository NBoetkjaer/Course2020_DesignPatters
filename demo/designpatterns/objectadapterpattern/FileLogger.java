package demo.designpatterns.objectadapterpattern;

import java.io.*;

/*
 * This is one of the Adaptee classes in the adapter pattern.
 */
public class FileLogger {

    private String filename;

    public FileLogger(String fn) {
        filename = fn;
    }

    public void appendMessage(String message) {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(filename, true));

            bw.write(message);
            bw.newLine();

            bw.close();
        } catch (IOException ex) {
            System.out.println("IOException occurred: " + ex);
        }
    }

    public void clearFile() {
        File f = new File(filename);
        f.delete();
    }
}
