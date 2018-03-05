package bensPackage;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

public class MyJPanel extends JPanel {
	
	private String JLabel1;
	private boolean JLabel1Enabled;
	
	public MyJPanel()
	{
		setOpaque(true);
		JLabel1 = "Testing";
		JLabel1Enabled = false;
	}
	
	public void setJLabel1(boolean input)
	{
		JLabel1Enabled = input;
		repaint();
	}
	
	public boolean getJLabel1()
	{
		return JLabel1Enabled;
	}
	
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		if(JLabel1Enabled)
		{
			g.drawString(JLabel1, 100, 100);
		}
	}
	
}
