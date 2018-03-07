package bensPackage;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

public class MyJPanel extends JPanel {
	
	private String JLabel1;
	private boolean JLabel1Enabled;
	private int listLocation;
	
	public MyJPanel(int location)
	{
		super();
		listLocation = location;
		setOpaque(false);
	}
	
	public int getListLocation()
	{
		return this.listLocation;
	}
	
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
	}
	
}
