package bensPackage;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.TextArea;
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
		MyJButton button1 = new MyJButton("Button", AbstractButton.CENTER, "button1");
		button1.setPreferredSize(new Dimension(100, 200));
		
		JLabel label1 = new JLabel("WestFiller");
		JLabel label2 = new JLabel("EastFiller", AbstractButton.CENTER);
		label2.setPreferredSize(new Dimension(100, 200));
		JLabel label3 = new JLabel("SouthFiller", AbstractButton.CENTER);
		label3.setPreferredSize(new Dimension(0, 100));
		
		TextArea txtArea = new TextArea();
		txtArea.setEditable(false);
		txtArea.setBackground(Color.GRAY);
		inputFrame.setText("Blah Blah Blah");
		
		inputFrame.addComponentToPanel(button1, BorderLayout.NORTH);
		inputFrame.addComponentToPanel(label1, BorderLayout.WEST);
		inputFrame.addComponentToPanel(label2, BorderLayout.EAST);
		inputFrame.addComponentToPanel(label3, BorderLayout.SOUTH);
		inputFrame.addComponentToPanel(txtArea);
		inputFrame.addActionListeners();
	}
	
	public void askForSize()
	{
		
	}

}