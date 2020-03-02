package demo.designpatterns.commandpattern;

import java.awt.*;
import java.awt.event.*;

interface Command {
    public void Execute();
}

public class DemoWithCommands extends Frame
        implements ActionListener {

    private static final long serialVersionUID = 1L;

    private Menu mnuFile;
    private fileOpenCommand mnuOpen;
    private fileExitCommand mnuExit;
    private btnRedCommand btnRed;
    private Panel p;
    private Frame fr;

    static public void main(String argv[]) {
        new DemoWithCommands();
    }

    //-----------------------------------------

    public DemoWithCommands() {

        super("Frame with commands");
        fr = this;     //save frame object

        MenuBar mbar = new MenuBar();
        setMenuBar(mbar);

        mnuFile = new Menu("File", true);
        mbar.add(mnuFile);

        mnuOpen = new fileOpenCommand("Open...");
        mnuFile.add(mnuOpen);
        mnuExit = new fileExitCommand("Exit");
        mnuFile.add(mnuExit);

        mnuOpen.addActionListener(this);
        mnuExit.addActionListener(this);

        btnRed = new btnRedCommand("Red");
        p = new Panel();
        add(p);
        p.add(btnRed);

        btnRed.addActionListener(this);
        setBounds(100, 100, 200, 100);
        setVisible(true);
    }


    public void actionPerformed(ActionEvent e) {
        Command obj = (Command) e.getSource();
        obj.Execute();
    }


    // Inner class.
    class btnRedCommand extends Button implements Command {

        private static final long serialVersionUID = 1L;

        public btnRedCommand(String caption) {
            super(caption);
        }

        public void Execute() {
            p.setBackground(Color.red);
        }
    }

    
    // Inner class.
    class fileOpenCommand extends MenuItem implements Command {

        private static final long serialVersionUID = 1L;

        public fileOpenCommand(String caption) {
            super(caption);
        }

        public void Execute() {
            FileDialog fDlg = new FileDialog(fr, "Open file");
            fDlg.setVisible(true);
        }
    }


    // Inner class.
    class fileExitCommand extends MenuItem implements Command {

        private static final long serialVersionUID = 1L;

        public fileExitCommand(String caption) {
            super(caption);
        }

        public void Execute() {
            System.exit(0);
        }
    }
}
