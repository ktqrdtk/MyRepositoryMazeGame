package bensPackage;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
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
		mzGm.maze = new Maze((int)Math.pow(mzGm.frame.getChosenSize(), 2));
		mzGm.frame.displayMazes(mzGm.maze);
		mzGm.resizePanel();
	}
	
	public void resizePanel()
	{
		String exampleWidth = "XXXXXXXXXXXX";
		Graphics graphics = this.frame.getGraphics();
		Font font = this.frame.getFont();
		FontMetrics metric = graphics.getFontMetrics();
		eastLabel.setText("East");
		westLabel.setText("West");
		if(this.maze.getSize() == 1)
		{
			int j = 0;
			System.out.println(this.frame.getTextAreaWidth());
			while(metric.stringWidth(exampleWidth) + 10 < this.frame.getTextAreaWidth())
			{
				int oldSize = eastLabel.getPreferredSize().width;
				this.eastLabel.setPreferredSize(new Dimension(oldSize + 10, eastLabel.getPreferredSize().height));
				this.frame.revalidate();
				this.frame.repaint();
				j++;
			}
		}
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
	
	public MyJFrame getFrame()
	{
		return this.frame;
	}

}