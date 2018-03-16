package tools;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class MazeToText implements ActionListener
{
	private JButton testButton, getButton;
	private JTextArea txtArea;
	private JPanel buttonPanel, mainPanel;
	private JFrame frame;
	private boolean valid;
	
	public static void main(String[] args)
	{
		
		SwingUtilities.invokeLater(new Runnable() 
		{
			public void run()
			{
				MazeToText main = new MazeToText();
				main.valid = false;
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
		txtArea.getDocument().addDocumentListener(new DocumentListener()
				{

					@Override
					public void changedUpdate(DocumentEvent arg0) 
					{
						valid = false;
						getButton.setEnabled(false);
					}

					@Override
					public void insertUpdate(DocumentEvent arg0) 
					{
						valid = false;
						getButton.setEnabled(false);
					}

					@Override
					public void removeUpdate(DocumentEvent arg0) 
					{
						valid = false;
						getButton.setEnabled(false);
					}
			
				});
		frame.revalidate();
		frame.repaint();
	}
	
	public void actionPerformed(ActionEvent evt)
	{
		String command = evt.getActionCommand();
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
	
	public boolean testMaze()
	{
		try
		{
			String[] array = stringToArray(this.txtArea.getText());
		}
		catch(StringLengthIncorrect ex)
		{
			System.out.println("Invalid");
			this.txtArea.setBackground(Color.RED);
			Timer timer = new Timer();
			timer.schedule(new TimerTask() {public void run() {SwingUtilities.invokeLater(new Runnable() {public void run() {txtArea.setBackground(Color.BLUE);}});}}, 3000);
			this.getButton.setEnabled(false);
			return false;
		}
		System.out.println("Valid");
		this.txtArea.setBackground(Color.GREEN);
		Timer timer = new Timer();
		timer.schedule(new TimerTask() {public void run() {SwingUtilities.invokeLater(new Runnable() {public void run() {txtArea.setBackground(Color.BLUE);}});}}, 3000);
		this.valid = true;
		this.getButton.setEnabled(true);
		return true;
	}
	
	public void getMaze()
	{
		
	}
	
	public static String[] stringToArray(String input) throws StringLengthIncorrect
	{
		try
		{
			String[] returnString = new String[12];
			String curString = "";
			for(int i = 0; i < 12; i++)
			{
				curString = input.substring(i * 13, (i * 13) + 12);
				if(curString.length() != 13)
				{
					throw new StringLengthIncorrect();
				}
				returnString[i] = curString;
			}
			return returnString;
		}
		catch(Exception ex)
		{
			throw new StringLengthIncorrect();
		}
	}

}
