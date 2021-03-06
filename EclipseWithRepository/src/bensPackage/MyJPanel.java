package bensPackage;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.LayoutManager;

import javax.swing.JPanel;

@SuppressWarnings({"serial", "unused"})
public class MyJPanel extends JPanel {
	
	private String JLabel1;
	private boolean JLabel1Enabled;
	private int listLocation;
	
	public MyJPanel(int location)
	{
		this(location, new BorderLayout());
	}
	
	public MyJPanel(int location, LayoutManager layout)
	{
		super();
		listLocation = location;
		setOpaque(false);
		this.setLayout(layout);
	}
	
	public int getListLocation()
	{
		return this.listLocation;
	}
	
	public MyJPanel(int location, boolean defaultLayout)
	{
		super();
		listLocation = location;
		setOpaque(false);
	}
	
}