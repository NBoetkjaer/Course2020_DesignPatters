package demo.designpatterns.decoratorpattern;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;

public class BufferedReaderDemo {

    public static void main(String[] args) {

        /*
        if (args.length != 1) {
            System.out.println("Specify name of file to read!");
            System.exit(0);
        }
        doDemo(args[0]);
        */
        
        doDemo("C:\\AdvJavaDev\\Temp\\Macbeth.txt"); 
    }

    public static void doDemo(String filename) {

        try {
            FileReader r = new FileReader(filename);
            BufferedReader br = new BufferedReader(r);
            LineNumberReader lr = new LineNumberReader(br);

            String line;

            while ((line = lr.readLine()) != null) {
                System.out.printf("[%4d] %s\n", lr.getLineNumber(), line);
            }

            br.close();
            r.close();

            System.out.println("\nThe End!");

        } catch (IOException ex) {
            System.out.println("Exception occurred: " + ex);
        }
    }
}
