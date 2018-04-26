package bensPackage;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.GridBagLayout;
import java.awt.TextArea;
import java.awt.Toolkit;
import java.io.File;

import javax.swing.AbstractButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.UIManager;

public class MazeGame
{
	private Player player;
	private Maze maze;
	private JLabel southLabel;
	private JLabel eastLabel;
	private JLabel westLabel;
	
	public static void main(String[] args) {
        try 
        {
        	UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        } 
        catch (Exception ex) 
        {
            ex.printStackTrace();
        }
        
        MazeGame mzGm = new MazeGame();
        mzGm.player = new Player();
		mzGm.createAndShowGUI();
		mzGm.player.frame.askForSize();
		//waits till size is chosen
		while(mzGm.player.frame.getChosenSize() == -1)
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
		mzGm.maze = new Maze((int)Math.pow(mzGm.player.frame.getChosenSize(), 2));
		int centerPanelNum = mzGm.player.frame.displayMazes(mzGm.maze);
		mzGm.player.setMaze(mzGm.maze);
		mzGm.player.frameInstantiated();
		mzGm.player.frame.finishDisplay(centerPanelNum);
	}
	
	public void readFile(int input)
	{
		new MazeReader(input);
	}
	
	public void createAndShowGUI()
	{
		player.frame = new MyJFrame("Maze Game - Ben Hilton", new BorderLayout());
		player.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//addComponentsToPanel(player.frame);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		player.frame.setPreferredSize(new Dimension(screenSize.height, screenSize.height)); 
		player.frame.pack();
		player.frame.setVisible(true);
	}
	
	public void addComponentsToPanel(MyJFrame inputFrame)
	{
		MyJButton button1 = new MyJButton("Button1", AbstractButton.CENTER, "button1");
		MyJButton button2 = new MyJButton("Button2", AbstractButton.CENTER, "button1");
		MyJButton button3 = new MyJButton("Button3", AbstractButton.CENTER, "button1");
		MyJButton button4 = new MyJButton("Hey", AbstractButton.TRAILING, "commandHere");
		
		westLabel = new JLabel();
		eastLabel = new JLabel();
		southLabel = new JLabel();
		
		MyJPanel upperPanel = new MyJPanel(inputFrame.getNumOfPanels());
		inputFrame.addPanelToList(upperPanel);
		upperPanel.setLayout(new GridBagLayout());
		inputFrame.addPanelToMainPanel(upperPanel.getListLocation(), BorderLayout.NORTH);
		
		inputFrame.addComponentToPanelNonLayout(button4, upperPanel.getListLocation());
		inputFrame.addComponentToPanelNonLayout(button1, upperPanel.getListLocation());
		inputFrame.addComponentToPanelNonLayout(button2, upperPanel.getListLocation());
		inputFrame.addComponentToPanelNonLayout(button3, upperPanel.getListLocation());
		inputFrame.addComponentToPanel(westLabel, BorderLayout.WEST, inputFrame.getMainPane().getListLocation());
		inputFrame.addComponentToPanel(eastLabel, BorderLayout.EAST, inputFrame.getMainPane().getListLocation());
		inputFrame.addComponentToPanel(southLabel, BorderLayout.SOUTH, inputFrame.getMainPane().getListLocation());
		inputFrame.addActionListeners();
	}

}