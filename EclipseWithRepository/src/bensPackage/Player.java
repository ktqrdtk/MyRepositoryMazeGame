package bensPackage;

import java.awt.event.KeyEvent;
import java.util.Random;

import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.JComponent;
import javax.swing.KeyStroke;

import controls.Controls;
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
	
	public void frameInstantiated()
	{
		bindControls();
		Random random = new Random();
		int randomNum = random.nextInt(maze.getNumOfGrids());
		curGrid = maze.getGrid(randomNum);
		Coordinate startPos = new Coordinate();
		if(curGrid.hasTopEz())
		{
			startPos.setCoords(7, 0);
		}
		else if(curGrid.hasLeftEz())
		{
			startPos.setCoords(0, 7);
		}
		else if(curGrid.hasRightEz())
		{
			startPos.setCoords(11, 7);
		}
		else
		{
			startPos.setCoords(7, 11);
		}
		curCoords = startPos;
		curGrid.setPos(curCoords);
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
	
	public void setMaze(Maze maze)
	{
		this.maze = maze;
	}
	
	public Maze getMaze()
	{
		return this.maze;
	}
}