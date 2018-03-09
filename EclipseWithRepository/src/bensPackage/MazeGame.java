package bensPackage;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.TextArea;
import java.io.File;

import javax.swing.AbstractButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.UIManager;

public class MazeGame
{
	private MyJFrame frame;
	
	public static void main(String[] args) {
        try 
        {
        	UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
            //UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        } 
        catch (Exception ex) 
        {
            ex.printStackTrace();
        }
        
        MazeGame mzGm = new MazeGame();
		javax.swing.SwingUtilities.invokeLater(new Runnable()
				{
					public void run()
					{
						mzGm.createAndShowGUI();
						mzGm.frame.askForSize();
					}
				});
		int totalNumOfMazesInFile = new File("MazesFolder").listFiles().length;
		mzGm.readFile(totalNumOfMazesInFile);
	}
	
	public void readFile(int input)
	{
		@SuppressWarnings("unused")
		MazeReader mazeReader = new MazeReader(input);
	}
	
	public void createAndShowGUI()
	{
		frame = new MyJFrame("Maze Game - Ben Hilton", new BorderLayout());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		addComponentsToPanel(frame);
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
        frame.pack();
        frame.setVisible(true);
	}
	
	public void addComponentsToPanel(MyJFrame inputFrame)
	{
		MyJButton button1 = new MyJButton("Button1", AbstractButton.CENTER, "button1");
		MyJButton button2 = new MyJButton("Button2", AbstractButton.CENTER, "button1");
		MyJButton button3 = new MyJButton("Button3", AbstractButton.CENTER, "button1");
		MyJButton button4 = new MyJButton("Hey Herschi", AbstractButton.TRAILING, "commandHere");
		button1.setPreferredSize(new Dimension(50, 50));
		
		JLabel label1 = new JLabel("WestFiller");
		JLabel label2 = new JLabel("EastFiller", AbstractButton.CENTER);
		label2.setPreferredSize(new Dimension(50, 0));
		JLabel label3 = new JLabel("SouthFiller", AbstractButton.CENTER);
		label3.setPreferredSize(new Dimension(50, 50));
		
		TextArea txtArea = new TextArea();
		txtArea.setEditable(false);
		txtArea.setBackground(new Color(00, 143, 00));
		inputFrame.setText("Blah Blah Blah");
		
		MyJPanel upperPanel = new MyJPanel(inputFrame.getNumOfPanels());
		inputFrame.addPanelToList(upperPanel);
		upperPanel.setLayout(new GridBagLayout());
		inputFrame.addPanelToMainPanel(upperPanel.getListLocation(), BorderLayout.NORTH);
		
		inputFrame.addComponentToPanelNonLayout(button4, upperPanel.getListLocation());
		inputFrame.addComponentToPanelNonLayout(button1, upperPanel.getListLocation());
		inputFrame.addComponentToPanelNonLayout(button2, upperPanel.getListLocation());
		inputFrame.addComponentToPanelNonLayout(button3, upperPanel.getListLocation());
		inputFrame.addComponentToPanel(label1, BorderLayout.WEST, inputFrame.getMainPane().getListLocation());
		inputFrame.addComponentToPanel(label2, BorderLayout.EAST, inputFrame.getMainPane().getListLocation());
		inputFrame.addComponentToPanel(label3, BorderLayout.SOUTH, inputFrame.getMainPane().getListLocation());
		inputFrame.addComponentToPanel(txtArea, BorderLayout.CENTER ,inputFrame.getMainPane().getListLocation());
		inputFrame.addActionListeners();
	}
	
	public MyJFrame getFrame()
	{
		return this.frame;
	}

}