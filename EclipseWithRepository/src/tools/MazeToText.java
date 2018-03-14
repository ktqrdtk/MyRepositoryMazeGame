package tools;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;

public class MazeToText implements ActionListener 
{
	private JButton testButton, getButton;
	private JTextArea txtArea;
	private JPanel buttonPanel, mainPanel;
	private JFrame frame;
	
	
	
	public static void main(String[] args)
	{
		
		SwingUtilities.invokeLater(new Runnable() 
		{
			public void run()
			{
				MazeToText main = new MazeToText();
				main.createGui();
			}
		});
		
	}
	
	public void createGui()
	{
		JFrame frame = new JFrame("Maze Maker!");
		JPanel mainPanel = new JPanel(new BorderLayout());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.pack();
		frame.setVisible(true);
		frame.add(mainPanel);
		addComponentsToPanel();
	}
	
	public void addComponentsToPanel()
	{
		txtArea = new JTextArea("*Put Maze Here*");
		testButton = new JButton("Test Out Maze");
		getButton = new JButton("Get Maze \nMust Be Tested");
		buttonPanel = new JPanel();
		buttonPanel.add(testButton);
		
	}
	
	public void actionPerformed(ActionEvent evt)
	{
		String command = evt.getActionCommand();
		switch(command)
		{
		case "testButton":
			testMaze();
			break;
			
		case "getMaze":
			getMaze();
			break;
		}
	}
	
	public void testMaze()
	{
		
	}
	
	public void getMaze()
	{
		
	}

}
