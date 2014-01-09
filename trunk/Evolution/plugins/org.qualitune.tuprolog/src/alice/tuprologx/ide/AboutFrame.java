package alice.tuprologx.ide;

import javax.swing.*;

import java.awt.*;
import java.net.URL;

public class AboutFrame
    extends GenericFrame
{
    
    private static final long serialVersionUID = 1L;

    public AboutFrame(JFrame mainWindow)
    {
        super("About tuProlog IDE", mainWindow, 275, 135, true, true);
        initComponents();
    }

    private void initComponents()
    {
        Container c=this.getContentPane();
        JLabel icon=new JLabel();
        URL urlImage = getClass().getResource("img/tuProlog.gif");
        icon.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().getImage(urlImage)));
        JLabel versionSystem=new JLabel(" tuProlog version " + alice.tuprolog.Prolog.getVersion());
        JLabel versionIDE=new JLabel(" tuProlog IDE version 3.0");
        JLabel copyright=new JLabel(" tuProlog is (C) Copyright 2001-2011 aliCE team");
        JLabel deis=new JLabel(" DEIS, Universita' di Bologna, Italy.");
        JLabel url=new JLabel(" URL: http://tuprolog.alice.unibo.it");
        
        c.setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.weightx = 1;
        constraints.weighty = 1;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.gridwidth = GridBagConstraints.REMAINDER;
        c.add(icon,constraints);
        constraints.gridy=1;
        c.add(versionSystem,constraints);
        constraints.gridy=2;
        c.add(versionIDE,constraints);
        constraints.gridy=3;
        c.add(new JLabel(" "),constraints);
        constraints.gridy=4;
        c.add(copyright,constraints);
        constraints.gridy=5;
        c.add(deis,constraints);
        constraints.gridy=6;
        c.add(url,constraints);
        pack();
        setVisible(true);
    }
}
