package bensPackage;

import java.awt.event.KeyEvent;
import java.util.Random;

import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.JComponent;
import javax.swing.KeyStroke;

import controls.Controls;
import controls.LocationType;
import controls.MoveAction;

public class Player
{
	public static final int IFW = JComponent.WHEN_IN_FOCUSED_WINDOW;
	
	public MyJFrame frame;
	private InputMap inputMap;
	private ActionMap actionMap;
	private Maze maze;
	private Grid curGrid;
	private Coordinate curCoords;
	private int curGridNum;
	private LocationType[] surroundings = new LocationType[8];
	
	public void frameInstantiated()
	{
		bindControls();
		setPlayerStartPos();
	}
	
	public void bindControls()
	{
		inputMap = frame.getMainPane().getInputMap(IFW);
		actionMap = frame.getMainPane().getActionMap();
		inputMap.put(KeyStroke.getKeyStroke("W"), Controls.UP_ACTION);
		inputMap.put(KeyStroke.getKeyStroke("S"), Controls.DOWN_ACTION);
		inputMap.put(KeyStroke.getKeyStroke("A"), Controls.LEFT_ACTION);
		inputMap.put(KeyStroke.getKeyStroke("D"), Controls.RIGHT_ACTION);
		inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_UP, 0), Controls.UP_ACTION);
		inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_DOWN, 0), Controls.DOWN_ACTION);
		inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_LEFT, 0), Controls.LEFT_ACTION);
		inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_RIGHT, 0), Controls.RIGHT_ACTION);
		actionMap.put(Controls.UP_ACTION, new MoveAction(Controls.UP_ACTION, this));
		actionMap.put(Controls.DOWN_ACTION, new MoveAction(Controls.DOWN_ACTION, this));
		actionMap.put(Controls.LEFT_ACTION, new MoveAction(Controls.LEFT_ACTION, this));
		actionMap.put(Controls.RIGHT_ACTION, new MoveAction(Controls.RIGHT_ACTION, this));
	}
	
	public void setPlayerStartPos()
	{
		curGridNum = getIntRandomGrid();
		curGrid = maze.getGrid(curGridNum);
		Coordinate startPos = new Coordinate();
		if(curGrid.hasTopEz())
		{
			startPos.setCoords(6, 0);
		}
		else if(curGrid.hasLeftEz())
		{
			startPos.setCoords(0, 6);
		}
		else if(curGrid.hasRightEz())
		{
			startPos.setCoords(11, 6);
		}
		else
		{
			startPos.setCoords(6, 11);
		}
		curCoords = startPos;
		curGrid.setPos(curCoords);
		this.updateCurTxtArea();
	}
	
	public void setMaze(Maze maze)
	{
		this.maze = maze;
	}
	
	public Maze getMaze()
	{
		return this.maze;
	}
	
	public int getCurGridNum()
	{
		return this.curGridNum;
	}
	
	public void updateCurTxtArea()
	{
		this.frame.updateTxtArea(this.getCurGridNum(), this.getMaze().getGrid(this.getCurGridNum()));
	}
	
	public int getIntRandomGrid()
	{
		int randomNum;
		Random random = new Random();
		do
		{
			randomNum = random.nextInt(maze.getNumOfGrids());
		}
		while(randomNum == maze.getMiddleGridNum());
		return randomNum;
	}
	
	public void updatePlayerSurroundings()
	{
		for(int i = 0; i < surroundings.length; i++)
		{
			surroundings[i] = getLocationType(i);
		}
	}
	
	public LocationType getLocationType(int input)
	{
		LocationType returnValue = LocationType.INVALID;
		int x = curCoords.x;
		int y = curCoords.y;
		
		//input values
		//  012
		//  3X4
		//  567
		
		switch(input)
		{
		case 0:
			Coordinate coord0 = new Coordinate(x - 1, y + 1);
			//top left
			if(coord0.x < 1)
			{
				
			}
			break;
		case 1:
			break;
		case 2:
			break;
		case 3:
			break;
		case 4:
			break;
		case 5:
			break;
		case 6:
			break;
		case 7:
			break;
		}
		
		return returnValue;
	}
	
}