package demo.designpatterns.objectadapterpattern;

import javax.swing.*;

/*
 * This is one of the Adaptee classes in the adapter pattern.
 */
public class GuiMessager {

    public void displayInfoMessage(String message) {
        JOptionPane.showMessageDialog(null, message, "Information message", JOptionPane.INFORMATION_MESSAGE);
    }

    public void displayWarningMessage(String message) {
        JOptionPane.showMessageDialog(null, message, "Warning message", JOptionPane.WARNING_MESSAGE);
    }

    public void displayErrorMessage(String message) {
        JOptionPane.showMessageDialog(null, message, "Error message", JOptionPane.ERROR_MESSAGE);
    }
}
