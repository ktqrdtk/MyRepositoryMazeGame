package bensPackage;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class MazeGame implements ActionListener {

	private MyJPanel panel;
	private JFrame frame;
	
	public static void main(String[] args) {
        try 
        {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        } 
        catch (Exception ex) 
        {
            ex.printStackTrace();
        }
        
        MazeGame mzGm = new MazeGame();
		javax.swing.SwingUtilities.invokeLater(new Runnable()
				{
					public void run()
					{
						mzGm.createAndShowGUI();
					}
				});
		int totalNumOfMazesInFile = new File("MazesFolder").listFiles().length;
		mzGm.readFile(totalNumOfMazesInFile);
		
		//askForSize();
	}
	
	public void readFile(int input)
	{
		MazeReader mazeReader = new MazeReader(input);
	}
	
	public void createAndShowGUI()
	{
		frame = new JFrame("Maze Game - Ben Hilton");
		panel = new MyJPanel();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		addComponentsToPanel(panel);
		frame.add(panel);
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
        frame.pack();
        frame.setVisible(true);
	}
	
	public void addComponentsToPanel(MyJPanel pane)
	{
		JButton button1 = new JButton("Start");
		button1.setHorizontalTextPosition(AbstractButton.LEADING);
		button1.setActionCommand("button1");
		button1.setEnabled(true);
		
		button1.addActionListener(this);
		
		pane.add(button1);
	}
	
	public void askForSize()
	{
		
	}

	public void actionPerformed(ActionEvent e) {
		if("button1".equals(e.getActionCommand()))
		{
			if(panel.getJLabel1())
			{
				panel.setJLabel1(false);
			}
			else
			{
				panel.setJLabel1(true);
			}
		}
		
	}

}