/*
 * tuProlog - Copyright (C) 2001-2004  aliCE team at deis.unibo.it
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307  USA
 */
package alice.tuprologx.ide;

import alice.tuprolog.*;
import alice.tuprolog.event.*;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

/**
 * The tuProlog IDE to be run on a Java2 platform. Makes use of Thinlet and
 * Swing for advanced components, e.g. a more advanced edit area.
 * 
 * @author    <a href="mailto:giulio.piancastelli@studio.unibo.it">Giulio Piancastelli</a>
 * @version    1.0 - 14-nov-02
 */

public class JavaIDE
    extends JFrame
{
    
    private static final long serialVersionUID = 1L;

    //private Prolog engine;
    private ToolBar toolBar;
    private TheoryTabbedPane tabbedPane;

    public JavaIDE() {
        super("tuProlog IDE");
        initComponents();
    }

    /**
     * Initialize the graphic components and set the dependencies among them.
     */
    private void initComponents() {
        System.out.println("tuProlog system - release " + Prolog.getVersion());

        Prolog engine = new Prolog();

        tabbedPane = new TheoryTabbedPane();
        tabbedPane.setEngine(engine);
        toolBar = new ToolBar(tabbedPane,this);
        tabbedPane.setToolBar(toolBar);

        StatusBar statusBar = new StatusBar();
        tabbedPane.setStatusBar(statusBar);

        TheoryEditor editor = new TheoryEditor(tabbedPane);
        tabbedPane.setTheoryEditor(editor);

        JavaInputField inputField = new JavaInputField();
        tabbedPane.setInputField(inputField);

        ConsoleManager consoleManager=new ConsoleManager(tabbedPane);
        ConsoleDialog consoleDialog = new ConsoleDialog(consoleManager);
        tabbedPane.setConsoleDialog(consoleDialog);

        PrologConfigFrame configFrame = new PrologConfigFrame(this,tabbedPane);
        configFrame.addPropertyChangeListener(consoleManager);
        configFrame.addPropertyChangeListener(consoleDialog);
        //set default value
        configFrame.setMillsStopEngine(5000);
        configFrame.setSelectDisplayModality(0);
        /*Castagna 06/2011*/       
        configFrame.setNotifyExceptionEvent(engine.isException());
        /**/

        toolBar.setPrologConfig(configFrame);


        tabbedPane.newTheory();
        tabbedPane.addChangeListener(tabbedPane);

        editor.setEngine(engine);
        editor.addPropertyChangeListener(statusBar);
        editor.setEditArea(tabbedPane.getSelectedTheoryEditArea());

        tabbedPane.getSelectedJavaEditArea().setBackground(new Color(230, 230, 230));

        consoleManager.setEngine(engine);
        consoleDialog.addPropertyChangeListener(statusBar);
        consoleDialog.setStatusMessage("Ready.");
        engine.addQueryListener(consoleManager);
        engine.addOutputListener(consoleDialog);
        /*Castagna 06/2011*/
		engine.addExceptionListener(consoleDialog);
		/**/
        consoleManager.addInformationToDisplayListener(consoleDialog);
        consoleManager.setDialog(consoleDialog);
        consoleDialog.setFileManager(new JavaIOManager(this));
        consoleDialog.setFileManagerType("csv");

        inputField.setBackground(new Color(230, 230, 230));
        inputField.setConsole(consoleManager);
        consoleManager.setInputField(inputField);

        LibraryManager libraryManager = new LibraryManager();
        libraryManager.setEngine(engine);
        toolBar.setLibraryManager(libraryManager);
        toolBar.setEngine(engine);
        toolBar.addPropertyChangeListener(statusBar);
        toolBar.setFileManager(new JavaIOManager(toolBar));
        toolBar.setFileManagerType("theory");

        addWindowListener(new WindowListener());



        //insert component in the panels
        JPanel consolePanel = new JPanel();
        consolePanel.setLayout(new BorderLayout());
        consolePanel.add(inputField, BorderLayout.NORTH);
        consolePanel.add(consoleDialog, BorderLayout.CENTER);

        JSplitPane splitPaneV = new JSplitPane( JSplitPane.VERTICAL_SPLIT );
        splitPaneV.setLeftComponent(tabbedPane);
        splitPaneV.setRightComponent(consolePanel);

        JPanel corePanel = new JPanel();
        corePanel.setLayout(new BorderLayout());
        corePanel.add(editor, BorderLayout.NORTH);
        corePanel.add(splitPaneV, BorderLayout.CENTER);

        JPanel IDEPanel = new JPanel();
        IDEPanel.setLayout(new BorderLayout());
        IDEPanel.add(toolBar, BorderLayout.NORTH);
        IDEPanel.add(corePanel, BorderLayout.CENTER);
        IDEPanel.add(statusBar, BorderLayout.SOUTH);

        getContentPane().add(IDEPanel);

        pack();
        setSize(new Dimension(585,675));
        splitPaneV.setResizeWeight(0.7);

        // Set a title bar icon
        ImageIcon icon = new ImageIcon(getClass().getResource("img/tuProlog.gif"));
        setIconImage(icon.getImage());
    }

    public void onOutput(OutputEvent e) {
        System.out.print(e.getMsg());
    }
    public void onSpy(SpyEvent e) {
        System.out.println(e.getMsg());
    }
    public void onWarning(WarningEvent e) {
        System.out.println(e.getMsg());
    }

    public void enableTheoryCommands(boolean flag) {
        tabbedPane.enableTheoryCommands(flag);
    }

    public boolean isFeededTheory() {
        return tabbedPane.isFeededTheory();
    }
    
    public void setFeededTheory(boolean flag) {
        tabbedPane.setFeededTheory(flag);
    }

    public String getEditorContent() {
        return tabbedPane.getEditorContent();
    }
    
    public void setEditorContent(String text) {
        tabbedPane.setEditorContent(text);
    }

    public void onClose()
    {
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        boolean isWindowClosable = true;
        for (int i=0;i<tabbedPane.getTabCount()&& isWindowClosable;i++)
        {
               isWindowClosable = tabbedPane.isClosable(i); 
        }
        if (isWindowClosable)
        {
            dispose();
            System.exit(0);
        }
    }

    class WindowListener extends WindowAdapter
    {
        public void windowClosing(WindowEvent w)
        {
            onClose();
        }
    }
} // end JavaIDE class