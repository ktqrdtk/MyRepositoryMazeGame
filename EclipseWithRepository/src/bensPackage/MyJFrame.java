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
	
	private MyJPanel panel;
	private ArrayList<JButton> listOfButtons;
	private ArrayList<JLabel> listOfLabels;
	private String currentText;
	private TextArea txtArea;
	
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
		this.addComponentToPanel(input, BorderLayout.NORTH);
	}
	
	public void addComponentToPanel(JLabel input)
	{
		this.addComponentToPanel(input, BorderLayout.CENTER);
	}
	
	public void addComponentToPanel(JLabel input, String location)
	{
		this.panel.add(input, location);
		this.listOfLabels.add(input);
		this.panel.repaint();
	}
	
	public void addComponentToPanel(JButton input, String location)
	{
		this.panel.add(input, location);
		this.listOfButtons.add(input);
		this.panel.repaint();
	}
	
	public void setText(String input)
	{
		this.setText(input, BorderLayout.CENTER);
	}
	
	public void setText(String input, String location)
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
	
	public void addText(String input, Boolean withEnterAfter)
	{
		if(withEnterAfter)
		{
			this.txtArea.append(input + "\n");
		}
		else
		{
			this.txtArea.append(input);
		}
		
		this.panel.repaint();
	}
	
	public void addComponentToPanel(TextArea input)
	{
		this.addComponentToPanel(input, BorderLayout.CENTER);
	}
	
	public void addComponentToPanel(TextArea input, String location)
	{
		this.txtArea = input;
		this.setText(currentText);
		this.panel.add(txtArea, location);
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
		/*case "button1":
			if(this.getPanel().getJLabel1())
			{
				this.getPanel().setJLabel1(false);
			}
			else
			{
				this.getPanel().setJLabel1(true);
			}*/
		}
	}
}
