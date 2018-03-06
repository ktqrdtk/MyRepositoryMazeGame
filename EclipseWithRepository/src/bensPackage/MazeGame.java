package bensPackage;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class MazeGame
{
	
	private MyJFrame frame;
	
	public static void main(String[] args) {
        try 
        {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
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
					}
				});
		int totalNumOfMazesInFile = new File("MazesFolder").listFiles().length;
		mzGm.readFile(totalNumOfMazesInFile);
		
		//askForSize();
	}
	
	public void readFile(int input)
	{
		MazeReader mazeReader = new MazeReader(input);
	}
	
	public void createAndShowGUI()
	{
		frame = new MyJFrame("Maze Game - Ben Hilton");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		addComponentsToPanel(frame);
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
        frame.pack();
        frame.setVisible(true);
	}
	
	public void addComponentsToPanel(MyJFrame inputFrame)
	{
		JButton button1 = new JButton("Start");
		button1.setHorizontalTextPosition(AbstractButton.LEADING);
		button1.setActionCommand("button1");
		button1.setEnabled(true);
		
		JLabel label1 = new JLabel("E'llo", SwingConstants.LEADING);
		
		inputFrame.addComponentToPanel(button1);
		inputFrame.addComponentToPanel(label1);
		inputFrame.addActionListeners();
	}
	
	public void askForSize()
	{
		
	}

}