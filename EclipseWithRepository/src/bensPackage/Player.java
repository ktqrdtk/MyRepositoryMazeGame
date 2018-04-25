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
	public Grid curGrid;
	public Coordinate curCoords;
	public int curGridNum;
	private LocationType[] surroundings = new LocationType[8];
	//private Coordinate[] entranceCoords = new Coordinate[8];
	public static final char PLAYER_ASCII = 'O';
	
	Player()
	{
		//setUpEntranceCoords();
	}
	
	public void frameInstantiated()
	{
		bindControls();
		setPlayerStartPos();
		updatePlayerSurroundings();
	}
	
	public void bindControls()
	{
		inputMap = frame.getMainPane().getInputMap(IFW);
		actionMap = frame.getMainPane().getActionMap();
		inputMap.put(KeyStroke.getKeyStroke("W"), Controls.UP_ACTION);
		inputMap.put(KeyStroke.getKeyStroke("S"), Controls.DOWN_ACTION);
		inputMap.put(KeyStroke.getKeyStroke("A"), Controls.LEFT_ACTION);
		inputMap.put(KeyStroke.getKeyStroke("D"), Controls.RIGHT_ACTION);
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
	
	/*public void setUpEntranceCoords()
	{
		entranceCoords[0] = new Coordinate(5, 0);
		entranceCoords[1] = new Coordinate(6, 0);
		entranceCoords[2] = new Coordinate(5, 11);
		entranceCoords[3] = new Coordinate(6, 11);
		entranceCoords[4] = new Coordinate(0, 5);
		entranceCoords[5] = new Coordinate(0, 6);
		entranceCoords[6] = new Coordinate(11, 5);
		entranceCoords[7] = new Coordinate(11, 6);
	}*/
	
	public void setMaze(Maze maze)
	{
		this.maze = maze;
	}
	
	public LocationType[] getSurroundings()
	{
		return surroundings;
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
		int x = curCoords.x;
		int y = curCoords.y;
		Coordinate inputCoord;
		//input values
		//  567
		//  3X4
		//  012
		
		switch(input)
		{
		case 0:
			inputCoord = new Coordinate(x - 1, y + 1);
			break;
		case 1:
			inputCoord = new Coordinate(x, y + 1);
			break;
		case 2:
			inputCoord = new Coordinate(x + 1, y + 1);
			break;
		case 3:
			inputCoord = new Coordinate(x - 1, y);
			break;
		case 4:
			inputCoord = new Coordinate(x + 1, y);
			break;
		case 5:
			inputCoord = new Coordinate(x - 1, y - 1);
			break;
		case 6:
			inputCoord = new Coordinate(x, y - 1);
			break;
		case 7:
			inputCoord = new Coordinate(x + 1, y - 1);
			break;
		default:
			return LocationType.INVALID;
		}
		if(inputCoord.x < 0 || inputCoord.y < 0 || inputCoord.x > 11 || inputCoord.y > 11)
		{
			return LocationType.OTHER_GRID;
		}
		else
		{
			switch(curGrid.getGrid()[inputCoord.y][inputCoord.x])
			{
			case 'X':
				return LocationType.EX;
			case '|':
				return LocationType.VERTICAL;
			case '-':
				return LocationType.HORIZONTAL;
			case ' ':
				return LocationType.SPACE;
			default:
				return LocationType.INVALID;
			}
		}
	}
	
}