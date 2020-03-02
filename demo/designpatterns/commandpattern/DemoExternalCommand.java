package demo.designpatterns.commandpattern;

import java.awt.*;
import java.awt.event.*;

public class DemoExternalCommand extends Frame
        implements ActionListener {

    private static final long serialVersionUID = 1L;

    private Menu mnuFile;
    private fileOpenCommand mnuOpen;
    private fileExitCommand mnuExit;
    private btnRedCommand btnRed;
    private Panel p;


    static public void main(String argv[]) {
        new DemoExternalCommand();
    }

    
    public DemoExternalCommand() {
        super("Frame with external commands");
        MenuBar mbar = new MenuBar();
        setMenuBar(mbar);

        mnuFile = new Menu("File", true);
        mbar.add(mnuFile);

        mnuOpen = new fileOpenCommand("Open...", this);
        mnuFile.add(mnuOpen);
        mnuExit = new fileExitCommand("Exit");
        mnuFile.add(mnuExit);

        mnuOpen.addActionListener(this);
        mnuExit.addActionListener(this);

        p = new Panel();
        add(p);
        btnRed = new btnRedCommand("Red", p);

        p.add(btnRed);

        btnRed.addActionListener(this);
        setBounds(100, 100, 200, 100);
        setVisible(true);
    }


    public void actionPerformed(ActionEvent e) {
        Command obj = (Command) e.getSource();
        obj.Execute();
    }
}

class btnRedCommand extends Button implements Command {

    private static final long serialVersionUID = 1L;
	
	Panel p;

    public btnRedCommand(String caption, Panel pnl) {
        super(caption);
        p = pnl;
    }

    public void Execute() {
        p.setBackground(Color.red);
    }
}


class fileOpenCommand extends MenuItem implements Command {

    private static final long serialVersionUID = 1L;

    Frame fr;

    public fileOpenCommand(String caption, Frame frm) {
        super(caption);
        fr = frm;
    }

    public void Execute() {
        FileDialog fDlg = new FileDialog(fr, "Open file");
        fDlg.setVisible(true);
    }
}


class fileExitCommand extends MenuItem implements Command {

    private static final long serialVersionUID = 1L;

    public fileExitCommand(String caption) {
        super(caption);
    }

    public void Execute() {
        System.exit(0);
    }
}
