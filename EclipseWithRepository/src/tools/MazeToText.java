package tools;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;
import javax.swing.border.Border;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class MazeToText implements ActionListener
{
	private JButton testButton, getButton;
	private JTextArea txtArea;
	private JPanel buttonPanel, mainPanel;
	private JFrame frame;
	private boolean valid;
	
	public static Color DEFAULTCOLOR = Color.WHITE;
	
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
		Font font = new Font(Font.MONOSPACED, Font.PLAIN, 60);
		Border blackline = BorderFactory.createLineBorder(Color.BLACK);
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
		txtArea.setBorder(blackline);
		txtArea.setFont(font);
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
		getButton.setEnabled(false);
		txtArea.setBackground(DEFAULTCOLOR);
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
			entrancesCorrect(array);
		}
		catch(StringLengthIncorrect ex)
		{
			this.txtArea.setBackground(Color.RED);
			Timer timer = new Timer();
			timer.schedule(new TimerTask() {public void run() {SwingUtilities.invokeLater(new Runnable() {public void run() {txtArea.setBackground(DEFAULTCOLOR);}});}}, 1000);
			this.getButton.setEnabled(false);
			return false;
		}
		this.txtArea.setBackground(Color.GREEN);
		Timer timer = new Timer();
		timer.schedule(new TimerTask() {public void run() {SwingUtilities.invokeLater(new Runnable() {public void run() {txtArea.setBackground(DEFAULTCOLOR);}});}}, 1000);
		this.valid = true;
		this.getButton.setEnabled(true);
		return true;
	}
	
	public static void entrancesCorrect(String[] array) throws StringLengthIncorrect
	{
		int enterCount = 0;
		StringLengthIncorrect exce = new StringLengthIncorrect();
		if(array[0].charAt(6) == ' ')
		{
			enterCount++;
		}
		if(array[6].charAt(0) == ' ')
		{
			enterCount++;
		}
		if(array[6].charAt(11) == ' ')
		{
			enterCount++;
		}
		if(array[11].charAt(6) == ' ')
		{
			enterCount++;
		}
		
		if(enterCount != 2)
		{
			System.out.println("Entrances Invalid, entrances: " + enterCount);
			throw exce;
		}
	}
	
	public void getMaze()
	{
		if(valid)
		{
			BufferedWriter bwriter = null;
			try
			{
				File file = new File("MazeX");
				bwriter = new BufferedWriter(new FileWriter(file));
				bwriter.write(this.txtArea.getText().substring(156));
			}
			catch(Exception ex)
			{
				
			}
			finally
			{
				try
				{
					bwriter.close();
				}
				catch(Exception exe)
				{
					
				}
			}
		}
		else
		{
			System.out.println("Maze Invalid Somehow");
		}
	}
	
	public static String[] stringToArray(String input) throws StringLengthIncorrect
	{
		try
		{
			String[] returnString = new String[12];
			String curString = "";
			for(int i = 0; i < 12; i++)
			{
				curString = input.substring(i * 13, (i * 13) + 13);
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
			System.out.println("Incorrect Size, cannot convert to array");
			throw new StringLengthIncorrect();
		}
	}

}
