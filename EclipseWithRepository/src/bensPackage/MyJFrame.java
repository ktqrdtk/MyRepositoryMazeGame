package bensPackage;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

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
		this.panelList.get(panelNum).add(input, location);
		this.listOfButtons.add(input);
		this.panelList.get(panelNum).repaint();
		this.repaint();
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
		case "button1":
			break;
		}
	}
	
}
