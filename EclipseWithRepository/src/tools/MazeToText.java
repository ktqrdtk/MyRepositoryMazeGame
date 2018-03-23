package tools;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;
import javax.swing.border.Border;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class MazeToText implements ActionListener
{
	private JButton testButton, getButton, resetButton;
	private JTextArea txtArea, errorArea;
	private JPanel buttonPanel, mainPanel, txtPanels;
	private JFrame frame;
	private boolean valid;
	
	public static Color DEFAULTCOLOR = Color.WHITE;
	public static String starterMaze = 
			"X----------X\n" + 
			"|          |\n" + 
			"|          |\n" + 
			"|          |\n" + 
			"|          |\n" + 
			"|          |\n" + 
			"|          |\n" + 
			"|          |\n" + 
			"|          |\n" + 
			"|          |\n" + 
			"|          |\n" + 
			"X----------X\n" + 
			"";
	
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
		txtArea = new JTextArea(starterMaze);
		txtArea.setMaximumSize(txtArea.getPreferredSize());
		txtArea.setMinimumSize(txtArea.getMinimumSize());
		errorArea = new JTextArea("Error log, test for potential errors.");
		errorArea.setPreferredSize(new Dimension(errorArea.getPreferredSize().width * 2, errorArea.getPreferredSize().height * 3));
		testButton = new JButton("Test Out Maze");
		getButton = new JButton("Get Maze \r\nMust Be Tested");
		resetButton = new JButton("Reset");
		resetButton.addActionListener(this);
		testButton.addActionListener(this);
		getButton.addActionListener(this);
		testButton.setActionCommand("testMaze");
		resetButton.setActionCommand("reset");
		getButton.setActionCommand("getMaze");
		testButton.setEnabled(true);
		getButton.setEnabled(true);
		buttonPanel = new JPanel();
		buttonPanel.setBackground(Color.DARK_GRAY);
		buttonPanel.setOpaque(true);
		buttonPanel.add(testButton);
		buttonPanel.add(getButton);
		buttonPanel.add(resetButton);
		txtPanels = new JPanel();
		txtPanels.add(txtArea);
		txtPanels.add(errorArea);
		mainPanel.add(buttonPanel, BorderLayout.SOUTH);
		mainPanel.add(txtPanels, BorderLayout.CENTER);
		txtArea.setBorder(blackline);
		txtArea.setFont(font);
		txtArea.selectAll();
		JLabel wst = new JLabel();
		wst.setBackground(Color.DARK_GRAY);
		wst.setPreferredSize(new Dimension(15, 15));
		JLabel est = new JLabel();
		est.setBackground(Color.DARK_GRAY);
		est.setPreferredSize(new Dimension(15, 15));
		JLabel nth = new JLabel();
		nth.setBackground(Color.DARK_GRAY);
		nth.setPreferredSize(new Dimension(15, 15));
		nth.setOpaque(true);
		wst.setOpaque(true);
		est.setOpaque(true);
		mainPanel.add(est, BorderLayout.EAST);
		mainPanel.add(wst, BorderLayout.WEST);
		mainPanel.add(nth, BorderLayout.NORTH);
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
			
		case "reset":
			txtArea.setText(starterMaze);
			break;
		}
	}
	
	public boolean testMaze()
	{
		try
		{
			String[] array = stringToArray(this.txtArea.getText());
			testChars(array);
			entrancesCorrect(array);
		}
		catch(IncorrectChars ex)
		{
			error("Invalid Character(s)");
			return false;
		}
		catch(IncorrectDimension ex)
		{
			error("Incorrect Size");
			return false;
		}
		catch(EntrancesIncorrect ex)
		{
			error("Incorrect Entrances");
			return false;
		}
		this.txtArea.setBackground(Color.GREEN);
		Timer timer = new Timer();
		timer.schedule(new TimerTask() {public void run() {SwingUtilities.invokeLater(new Runnable() {public void run() {txtArea.setBackground(DEFAULTCOLOR);}});}}, 1000);
		this.valid = true;
		this.getButton.setEnabled(true);
		this.errorArea.setText("No Errors!!! Press get maze to import the file.");
		return true;
	}
	
	public static void entrancesCorrect(String[] array) throws EntrancesIncorrect
	{
		int doubleEnterCount = 0;
		int singleEnterCount = 0;
		int top = 0;
		int bottom = 0;
		int right = 0;
		int left = 0;
		EntrancesIncorrect exce = new EntrancesIncorrect();
		
		if(array[0].charAt(6) == ' ')
		{
			singleEnterCount++;
			top++;
		}
		if(array[0].charAt(5) == ' ')
		{
			singleEnterCount++;
			top++;
		}
		if(array[6].charAt(0) == ' ')
		{
			singleEnterCount++;
			left++;
		}
		if(array[5].charAt(0) == ' ')
		{
			singleEnterCount++;
			left++;
		}
		if(array[6].charAt(11) == ' ')
		{
			singleEnterCount++;
			right++;
		}
		if(array[5].charAt(11) == ' ')
		{
			singleEnterCount++;
			right++;
		}
		if(array[11].charAt(5) == ' ')
		{
			singleEnterCount++;
			bottom++;
		}
		if(array[11].charAt(7) == ' ')
		{
			singleEnterCount++;
			bottom++;
		}
		
		if(top == 2)
		{
			doubleEnterCount++;
		}
		if(bottom == 2)
		{
			doubleEnterCount++;
		}
		if(right == 2)
		{
			doubleEnterCount++;
		}
		if(left == 2)
		{
			doubleEnterCount++;
		}
		
		if(!(doubleEnterCount == 2 && singleEnterCount == 2 * doubleEnterCount))
		{
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
				bwriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("MazeX.txt"), "utf-8"));
				bwriter.write(this.txtArea.getText());
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
	
	public static String[] stringToArray(String input) throws IncorrectDimension
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
					throw new IncorrectDimension();
				}
				returnString[i] = curString;
			}
			return returnString;
		}
		catch(Exception ex)
		{
			System.out.println("Incorrect Size, cannot convert to array");
			throw new IncorrectDimension();
		}
	}
	
	public static void testChars(String[] array) throws IncorrectChars
	{
		for(int i = 0; i < array.length; i++)
		{
			for(int j = 0; j < array[i].length(); j++)
			{
				char curChar = array[i].charAt(j);
				
				//testAgainst returns true if it equals one of them.
				if(!testAgainst(curChar, ' ', 'X', '|', '-', '\n', '\r'))
				{
					throw new IncorrectChars();
				}
			}
		}
	}
	
	public static boolean testAgainst(char value, char... others)
	{
		for(int i = 0; i < others.length; i++)
		{
			if(value == others[i])
			{
				return true;
			}
		}
		return false;
	}
	
	public void error(String errorMessage)
	{
		this.txtArea.setBackground(Color.RED);
		Timer timer = new Timer();
		timer.schedule(new TimerTask() {public void run() {SwingUtilities.invokeLater(new Runnable() {public void run() {txtArea.setBackground(DEFAULTCOLOR);}});}}, 1000);
		this.getButton.setEnabled(false);
		this.errorArea.setText(errorMessage);
	}

}
