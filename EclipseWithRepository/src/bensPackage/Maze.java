package bensPackage;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JTextArea;

import controls.Controls;

@SuppressWarnings("unused")
public class Maze {
	
	private int numOfGrids;
	private Grid[][] maze;
	private int fontSize;
	private int size;
	private boolean colorBool;
	private Color forGround;
	private int time = 0;
	public ArrayList<JTextArea> completedTxtAreas;
	private static final int COLOR_UPDATE_INTERVAL = 1000;
	private static final Color firstColor = Color.GREEN;
	private static final Color secondColor = Color.MAGENTA;
	
	public Maze(int numOfGrids)
	{
		this.numOfGrids = numOfGrids;
		this.size = (int)Math.sqrt(numOfGrids);
		Generator myGen = new Generator();
		this.maze = myGen.setMaze(numOfGrids);
		this.completedTxtAreas = new ArrayList<JTextArea>();
		if(getSize() == 1)
		{
			fontSize = 60;
		}
		else if(getSize() == 2)
		{
			fontSize = 28;
		}
		else if(getSize() == 3)
		{
			fontSize = 18;
		}
		else
		{
			fontSize = 15;
		}
	}
	
	public Grid[][] getMaze()
	{
		return maze;
	}
	
	public int getSize()
	{
		return this.size;
	}
	
	public int getNumOfGrids()
	{
		return this.numOfGrids;
	}
	
	public String getString(int location, boolean hasSpaces)
	{
		String returnString = "";
		char[][] thisGrid = this.getGrid(location).getGrid();
		for(int i = 0; i < thisGrid.length; i++)
		{
			for(int j = 0; j < thisGrid[i].length; j++)
			{
				returnString += thisGrid[i][j];
				if(hasSpaces && j < (thisGrid[i].length - 1))
				{
					returnString += " ";
				}
			}
			if(i < (thisGrid.length - 1))
			{
				returnString += "\n";
			}
		}
		return returnString;
	}
	
	public int getFontSize()
	{
		return this.fontSize;
	}
	
	public Grid getGrid(int location)
	{
		Coordinate coord = Coordinate.getCoords(location, size);
		return maze[coord.y][coord.x];
	}
	
	public int getMiddleGridNum()
	{
		switch(this.size)
		{
		case 1:
			return 0;
		case 3:
			return 4;
		default:
			return -1;
		}
	}
	
	public int getGridNumRelative(Controls direction, int oldNum)
	{
		switch(direction)
		{
		case UP_ACTION :
			return oldNum - size;
		case DOWN_ACTION :
			return oldNum + size;
		case LEFT_ACTION :
			return oldNum - 1;
		case RIGHT_ACTION :
			return oldNum + 1;
		}
		return -5;
	}
	
	public void markTxtAreaComplete(int input, MyJFrame frame)
	{
		completedTxtAreas.add(frame.getTextArea(input));
	}
	
	public void markTxtAreaComplete(JTextArea input)
	{
		completedTxtAreas.add(input);
	}
	
	public void startUpdatingColors()
	{
		TimerTask task = new TimerTask()
				{
					public void run()
					{
						oneColorUpdate();
					}
				};
		Timer timer = new Timer();
		timer.schedule(task, 0, COLOR_UPDATE_INTERVAL);
	}
	
	public void oneColorUpdate()
	{
		if(colorBool)
		{
			forGround = firstColor;
			colorBool = false;
		}
		else
		{
			forGround = secondColor;
			colorBool = true;
		}
		for(int i = 0; i < completedTxtAreas.size(); i++)
		{
			completedTxtAreas.get(i).setForeground(forGround);
		}
		this.time++;
	}
	
	public int getTime()
	{
		return this.time;
	}
	
}
