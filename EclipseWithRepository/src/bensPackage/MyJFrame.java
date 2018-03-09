package bensPackage;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings({ "serial", "unused" })
public class MyJFrame extends JFrame implements ActionListener{
	
	private ArrayList<MyJPanel> panelList;
	private ArrayList<JButton> listOfButtons;
	private ArrayList<JLabel> listOfLabels;
	private String currentText;
	private TextArea txtArea;
	private int chosenSize;
	
	public MyJFrame(String input, LayoutManager layout)
	{
		super(input);
		MyJPanel panel = new MyJPanel(0);
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
	}
	
	public void addPanelToMainPanel(int index, String location)
	{
		this.getMainPane().add(panelList.get(index), location);
	}
	
	public void addComponentToPanelNonLayout(JButton input, int panelNum)
	{
		this.panelList.get(panelNum).add(input);
		this.listOfButtons.add(input);
		this.panelList.get(panelNum).repaint();
		this.repaint();
	}
	
	public void addComponentToPanel(JLabel input, String location, int panelNum)
	{
		this.panelList.get(panelNum).add(input, location);
		this.listOfLabels.add(input);
		this.panelList.get(panelNum).repaint();
		this.repaint();
	}
	
	public void addComponentToPanel(JButton input, String location, int panelNum)
	{
		if(!location.equals("noLayout"))
		{
			this.panelList.get(panelNum).add(input, location);
			this.listOfButtons.add(input);
			this.panelList.get(panelNum).repaint();
			this.repaint();
		}
		else
		{
			this.panelList.get(panelNum).add(input);
			this.listOfButtons.add(input);
			this.panelList.get(panelNum).repaint();
			this.repaint();
		}

	}
	
	public void setText(String input)
	{
		this.currentText = input;
		try
		{
			this.txtArea.setText(currentText);
		}
		catch(Exception ex)
		{
			//will error when txtarea hasnt been set
		}
	}
	
	public void addText(String input, Boolean withEnterAfter, int panelNum)
	{
		if(withEnterAfter)
		{
			this.txtArea.append(input + "\n");
		}
		else
		{
			this.txtArea.append(input);
		}
		
		this.panelList.get(panelNum).repaint();
	}
	
	public void addComponentToPanel(TextArea theTextArea, String location, int panelNum)
	{
		this.txtArea = theTextArea;
		txtArea.setText(currentText);
		this.panelList.get(panelNum).add(txtArea, location);
		this.panelList.get(panelNum).repaint();
		this.repaint();
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
			break;
		
		case "size2":
			chosenSize = 2;
			break;
			
		case "size3":
			chosenSize = 2;
			break;
		}
	}
	
	public void askForSize()
	{
		MyJPanel askingPanel = new MyJPanel(this.getNumOfPanels());
		this.addPanelToList(askingPanel);
		MyJPanel buttonPanel = new MyJPanel(this.getNumOfPanels(), new FlowLayout());
		this.addPanelToList(buttonPanel);
		askingPanel.add(buttonPanel, BorderLayout.CENTER);
		JLabel upperLabel = new JLabel("Please Choose Your Maze Size", (int) JLabel.CENTER_ALIGNMENT);
		this.addComponentToPanel(upperLabel, BorderLayout.NORTH, askingPanel.getListLocation());
		this.addPanelToFrame(askingPanel.getListLocation(), BorderLayout.CENTER);
		this.remove(this.getMainPane());
		//readd it later
		

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
	
}
