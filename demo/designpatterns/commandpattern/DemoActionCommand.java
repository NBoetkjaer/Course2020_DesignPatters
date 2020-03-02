package demo.designpatterns.commandpattern;

import java.awt.*;
import java.awt.event.*;

public class DemoActionCommand extends Frame {

    private static final long serialVersionUID = 1L;
	
	private Menu mnuFile;
    private MenuItem mnuOpen, mnuExit;
    private Button btnRed;
    private Panel p;
    private Frame fr;

    static public void main(String argv[]) {
        new DemoActionCommand();
    }

    public DemoActionCommand() {
        super("Frame without commands");
        fr = this;        //sae cop of this frame
        MenuBar mbar = new MenuBar();
        setMenuBar(mbar);

        mnuFile = new Menu("File", true);
        mbar.add(mnuFile);

        mnuOpen = new MenuItem("Open...");
        mnuFile.add(mnuOpen);
        mnuExit = new MenuItem("Exit");
        mnuFile.add(mnuExit);

        mnuOpen.addActionListener(new fileOpen());
        mnuExit.addActionListener(new fileExit());

        btnRed = new Button("Red");
        p = new Panel();
        add(p);
        p.add(btnRed);

        btnRed.addActionListener(new btnRed());
        setBounds(100, 100, 200, 100);
        setVisible(true);
    }

    public void exitClicked() {
        System.exit(0);
    }


    class fileOpen implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            FileDialog fDlg = new FileDialog(fr, "Open a file", FileDialog.LOAD);
            fDlg.setVisible(true);
        }
    }


    class btnRed implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            p.setBackground(Color.red);
        }
    }


    class fileExit implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            System.exit(0);
        }
    }
}