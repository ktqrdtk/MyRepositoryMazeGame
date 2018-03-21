package bensPackage;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.AbstractButton;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

@SuppressWarnings({"serial"})
public class MyJFrame extends JFrame implements ActionListener{
	
	private ArrayList<MyJPanel> panelList;
	private ArrayList<JButton> listOfButtons;
	private ArrayList<JLabel> listOfLabels;
	private int chosenSize;
	private MyJPanel askingPanel;
	private Font font;
	private int textAreaWidth;
	
	public MyJFrame(String input, LayoutManager layout)
	{
		super(input);
		MyJPanel panel = new MyJPanel(0);
		panel.setPreferredSize(new Dimension(200, 200));
		panel.setLayout(layout);
		listOfButtons = new ArrayList<JButton>();
		listOfLabels = new ArrayList<JLabel>();
		panelList = new ArrayList<MyJPanel>();
		panelList.add(panel);
		this.add(panelList.get(panel.getListLocation()));
		this.chosenSize = -1;
	}
	
	public int getNumOfPanels()
	{
		return this.panelList.size();
	}
	
	public MyJPanel getMainPane()
	{
		return this.panelList.get(0);
	}
	
	public int addPanelToList(MyJPanel thePanel)
	{
		// when using use like this:  
		//MyJPanel upperPanel = new MyJPanel(inputFrame.getNumOfPanels());
		//inputFrame.addPanel(upperPanel);
		
		
		panelList.add(thePanel);
		return panelList.size() - 1;
	}
	
	public void addPanelToFrame(int index, String location)
	{
		this.add(panelList.get(index), location);
		this.revalidate();
		this.repaint();
	}
	
	public void addPanelToMainPanel(int index, String location)
	{
		this.getMainPane().add(panelList.get(index), location);
		this.revalidate();
		this.repaint();
	}
	
	public void addComponentToPanelNonLayout(JButton input, int panelNum)
	{
		this.panelList.get(panelNum).add(input);
		this.listOfButtons.add(input);
		this.revalidate();
		this.repaint();
	}
	
	public void addComponentToPanel(JLabel input, String location, int panelNum)
	{
		this.panelList.get(panelNum).add(input, location);
		this.listOfLabels.add(input);
		this.revalidate();
		this.repaint();
	}
	
	public void addComponentToPanel(JButton input, String location, int panelNum)
	{
		if(!location.equals("noLayout"))
		{
			this.panelList.get(panelNum).add(input, location);
			this.listOfButtons.add(input);
			this.revalidate();
			this.repaint();
		}
		else
		{
			this.panelList.get(panelNum).add(input);
			this.listOfButtons.add(input);
			this.revalidate();
			this.repaint();
		}

	}
	
	public void setText(String input, TextArea txtArea)
	{
		String currentText = input;
		try
		{
			txtArea.setText(currentText);
		}
		catch(Exception ex)
		{
			//will error when txtarea hasnt been set, which is fine
		}
		this.revalidate();
		this.repaint();
	}
	
	public void addText(String input, Boolean withEnterAfter, int panelNum, TextArea txtArea)
	{
		if(withEnterAfter)
		{
			txtArea.append(input + "\n");
		}
		else
		{
			txtArea.append(input);
		}
		
		panelList.get(panelNum).repaint();
	}
	
	public void addComponentToPanel(TextArea theTextArea, String location, int panelNum)
	{
		if(!(location.equals("irregular")))
		{
			this.panelList.get(panelNum).add(theTextArea, location);
			this.revalidate();
			this.repaint();
		}
		else
		{
			this.panelList.get(panelNum).add(theTextArea);
			this.revalidate();
			this.repaint();
		}
	}
	
	public MyJPanel getPanel(int panelNum)
	{
		return this.panelList.get(panelNum);
	}
	
	public void addActionListeners()
	{
		for(int i = 0; i < listOfButtons.size(); i++)
		{
			listOfButtons.get(i).addActionListener(this);
		}
	}
	
	public void actionPerformed(ActionEvent e)
	{
		switch(e.getActionCommand())
		{
		case "size1":
			chosenSize = 1;
			removeUpperPanel();
			break;
		
		case "size2":
			chosenSize = 2;
			removeUpperPanel();
			break;
			
		case "size3":
			chosenSize = 3;
			removeUpperPanel();
			break;
			
		case "button4message":
		}
	}
	
	public void removeUpperPanel()
	{
		this.remove(askingPanel);
		this.add(this.getMainPane());
		this.setText(String.valueOf(this.chosenSize), new TextArea());
		this.revalidate();
		this.repaint();
	}
	
	public int getChosenSize()
	{
		return this.chosenSize;
	}
	
	public void askForSize()
	{
		askingPanel = new MyJPanel(this.getNumOfPanels());
		this.addPanelToList(askingPanel);
		MyJPanel buttonPanel = new MyJPanel(this.getNumOfPanels(), new FlowLayout());
		this.addPanelToList(buttonPanel);
		askingPanel.add(buttonPanel, BorderLayout.CENTER);
		JLabel upperLabel = new JLabel("Please Choose Your Maze Size", (int) JLabel.CENTER_ALIGNMENT);
		this.addComponentToPanel(upperLabel, BorderLayout.NORTH, askingPanel.getListLocation());
		this.addPanelToFrame(askingPanel.getListLocation(), BorderLayout.CENTER);
		this.remove(this.getMainPane());
		//re add it later
		

		this.addButtonsForSize(buttonPanel);
	}
	
	public void addButtonsForSize(MyJPanel inputPanel)
	{
		MyJButton b1 = new MyJButton("1 X 1", (int)AbstractButton.CENTER_ALIGNMENT, "size1");
		MyJButton b2 = new MyJButton("2 X 2", (int)AbstractButton.CENTER_ALIGNMENT, "size2");
		MyJButton b3 = new MyJButton("3 X 3", (int)AbstractButton.CENTER_ALIGNMENT, "size3");
		this.listOfButtons.add(b1);
		this.listOfButtons.add(b2);
		this.listOfButtons.add(b3);
		addActionListeners();
		this.addComponentToPanelNonLayout(b1, inputPanel.getListLocation());
		this.addComponentToPanelNonLayout(b2, inputPanel.getListLocation());
		//this ^^ and this vvv do the same thing just call them differently
		this.addComponentToPanel(b3, "noLayout", inputPanel.getListLocation());
	}
	
	public void displayMazes(Maze maze)
	{
		GridLayout gridLayout = new GridLayout(0, maze.getSize());
		gridLayout.setHgap(0);
		gridLayout.setVgap(0);
		int curLocation = 0;
		Random random = new Random();
		int num1 = random.nextInt(250);
		int num2 = random.nextInt(250);
		int num3 = random.nextInt(250);
		MyJPanel centerPanel = new MyJPanel(this.panelList.size(), gridLayout);
		this.addPanelToList(centerPanel);
		this.revalidate();
		this.repaint();
		for(int i = 0; i < maze.getMaze().length; i++)
		{
			for(int j = 0; j < maze.getMaze()[i].length; j++)
			{
				num1 = random.nextInt(250);
				num2 = random.nextInt(250);
				num3 = random.nextInt(250);
				TextArea txtArea = new TextArea("", 5, 10, TextArea.SCROLLBARS_NONE);
				this.font = new Font(Font.MONOSPACED, Font.PLAIN, maze.getFontSize());
				txtArea.setFont(this.font);
				txtArea.setEditable(false);
				txtArea.setBackground(new Color(num1, num2, num3));
				txtArea.setText(maze.getString(curLocation, true));
				this.addComponentToPanel(txtArea, "irregular", centerPanel.getListLocation());
				curLocation++;
				this.textAreaWidth = (int)txtArea.getBounds().getWidth();
			}
		}
		
		this.addPanelToMainPanel(centerPanel.getListLocation(), BorderLayout.CENTER);
	}
	
	public Font getFont()
	{
		return this.font;
	}
	
	public int getTextAreaWidth()
	{
		return this.textAreaWidth;
	}
	
	public JLabel increaseWidthLabels(JLabel label1, double howMuch)
	{
		JLabel newLabel = new JLabel();
		newLabel.setPreferredSize(new Dimension(label1.getPreferredSize().width, label1.getPreferredSize().height));
		return newLabel;
	}
	
}
