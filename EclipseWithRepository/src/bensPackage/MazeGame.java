package bensPackage;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
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
		mzGm.createAndShowGUI();
		mzGm.frame.askForSize();
		//waits till size is chosen
		while(mzGm.frame.getChosenSize() == -1)
		{
			try 
			{
				Thread.sleep(1000);
			} 
			catch (InterruptedException e) 
			{
				e.printStackTrace();
			}
		}

		int totalNumOfMazesInFile = new File("MazesFolder").listFiles().length;
		mzGm.readFile(totalNumOfMazesInFile);
		Maze maze = new Maze((int)Math.pow(mzGm.frame.getChosenSize(), 2));
		mzGm.frame.displayMazes(maze);
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
		MyJButton button4 = new MyJButton("Hey", AbstractButton.TRAILING, "commandHere");
		
		JLabel label1 = new JLabel();
		JLabel label2 = new JLabel();
		JLabel label3 = new JLabel();
		
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
		inputFrame.addActionListeners();
	}
	
	public MyJFrame getFrame()
	{
		return this.frame;
	}

}