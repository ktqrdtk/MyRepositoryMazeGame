package bensPackage;

import javax.swing.JFrame;

public class MazeGame {

	public static void main(String[] args) {
		
		javax.swing.SwingUtilities.invokeLater(new Runnable()
				{
					public void run()
					{
						createAndShowGUI();
					}
				});
		
		createAndShowGUI();
		int totalNumOfMazesInFile = 4;
		//int totalNumOfMazesInFile = new File("  put dir here  ").listFiles().length();
		readFile(totalNumOfMazesInFile);
		
		//askForSize();
	}
	
	public static void readFile(int input)
	{
		MazeReader mazeReader = new MazeReader(input);
	}
	
	public static void createAndShowGUI()
	{
		JFrame frame = new JFrame("Maze Game - Ben Hilton");
		MyJPanel panel = new MyJPanel();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(panel);
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
        frame.pack();
        frame.setVisible(true);
	}

}