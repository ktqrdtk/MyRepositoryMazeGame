package bensPackage;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

public class MyJPanel extends JPanel {
	
	public MyJPanel()
	{
		setBorder(BorderFactory.createLineBorder(Color.GREEN));
		setOpaque(true);
	}
	
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		
	}
	
}
