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
		frame = new JFrame("Maze Maker!");
		mainPanel = new JPanel(new BorderLayout());
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
		testButton.addActionListener(this);
		getButton.addActionListener(this);
		testButton.setActionCommand("testMaze");
		getButton.setActionCommand("getMaze");
		testButton.setEnabled(true);
		getButton.setEnabled(true);
		buttonPanel = new JPanel();
		buttonPanel.add(testButton);
		buttonPanel.add(getButton);
		mainPanel.add(buttonPanel, BorderLayout.SOUTH);
		mainPanel.add(txtArea, BorderLayout.CENTER);
		frame.revalidate();
		frame.repaint();
	}
	
	public void actionPerformed(ActionEvent evt)
	{
		String command = evt.getActionCommand();
		System.out.println(command);
		switch(command)
		{
		case "testMaze":
			testMaze();
			break;
			
		case "getMaze":
			getMaze();
			break;
		}
	}
	
	public void testMaze()
	{
		String[] array = stringToArray(this.txtArea.getText());
		System.out.println(array[0]);
		System.out.println("Testing Maze");
	}
	
	public void getMaze()
	{
		
	}
	
	public static String[] stringToArray(String input)
	{
		String[] array = new String[12];
		char curChar = input.charAt(0);
		String curLine = "";
		for(int i = 0; i < input.length(); i++)
		{
			curChar = input.charAt(i);
			if(curChar != '\n')
			{
				curLine += curChar;
			}
			else
			{
				array[i] = curLine;
				curLine = "";
			}
		}
		return array;
	}

}
