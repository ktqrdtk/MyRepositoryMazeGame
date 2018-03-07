package bensPackage;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;

@SuppressWarnings({ "serial", "unused" })
public class MyJFrame extends JFrame implements ActionListener{
	
	private MyJPanel panel;
	private ArrayList<JButton> listOfButtons;
	private ArrayList<JLabel> listOfLabels;
	
	public MyJFrame(String input, LayoutManager layout)
	{
		super(input);
		panel = new MyJPanel();
		panel.setLayout(layout);
		listOfButtons = new ArrayList<JButton>();
		listOfLabels = new ArrayList<JLabel>();
		this.add(panel);
	}
	
	public MyJFrame(String input)
	{
		this(input, new BorderLayout());
	}
	
	public void addComponentToPanel(JButton input)
	{
		this.panel.add(input);
		this.listOfButtons.add(input);
		this.panel.repaint();
	}
	
	public void addComponentToPanel(JLabel input)
	{
		this.panel.add(input);
		this.listOfLabels.add(input);
		this.panel.repaint();
	}
	
	public MyJPanel getPanel()
	{
		return this.panel;
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
			if(this.getPanel().getJLabel1())
			{
				this.getPanel().setJLabel1(false);
			}
			else
			{
				this.getPanel().setJLabel1(true);
			}
		}
	}
}
