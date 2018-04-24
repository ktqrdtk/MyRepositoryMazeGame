package controls;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import bensPackage.Maze;
import bensPackage.Player;

public class MoveAction extends AbstractAction
{
	private static final long serialVersionUID = 1L;
	Controls direction;
	Player player;
	Maze maze;
	public MoveAction(Controls direction, Player player)
	{
		this.player = player;
		this.maze = player.getMaze();
		this.direction = direction;
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		if(direction == Controls.UP_ACTION)
		{
			up();
		}
		else if(direction == Controls.DOWN_ACTION)
		{
			down();
		}
		else if(direction == Controls.LEFT_ACTION)
		{
			left();
		}
		else if(direction == Controls.RIGHT_ACTION)
		{
			right();
		}
	}
	
	public void up()
	{
		LocationType moveTo = player.getSurroundings()[6];
		if(moveTo == LocationType.SPACE)
		{
			player.curGrid.getGrid()[player.curCoords.y][player.curCoords.x] = ' ';
			player.curCoords.setCoords(player.curCoords.x, player.curCoords.y - 1);
			player.curGrid.getGrid()[player.curCoords.y][player.curCoords.x] = '#';
		}
		else if(moveTo == LocationType.OTHER_GRID)
		{
			player.curGrid.getGrid()[player.curCoords.y][player.curCoords.x] = ' ';
			player.updateCurTxtArea();
			player.curGridNum = maze.getGridNumRelative(Controls.UP_ACTION, player.curGridNum);
			player.curGrid = maze.getGrid(player.curGridNum);
			player.curCoords.setCoords(player.curCoords.x, player.curCoords.y + 11);
			player.curGrid.getGrid()[player.curCoords.y][player.curCoords.x] = '#';
		}
		player.updateCurTxtArea();
		player.updatePlayerSurroundings();
	}
	
	public void down()
	{
		LocationType moveTo = player.getSurroundings()[1];
		if(moveTo == LocationType.SPACE)
		{
			player.curGrid.getGrid()[player.curCoords.y][player.curCoords.x] = ' ';
			player.curCoords.setCoords(player.curCoords.x, player.curCoords.y + 1);
			player.curGrid.getGrid()[player.curCoords.y][player.curCoords.x] = '#';
		}
		else if(moveTo == LocationType.OTHER_GRID)
		{
			player.curGrid.getGrid()[player.curCoords.y][player.curCoords.x] = ' ';
			player.updateCurTxtArea();
			player.curGridNum = maze.getGridNumRelative(Controls.DOWN_ACTION, player.curGridNum);
			player.curGrid = maze.getGrid(player.curGridNum);
			player.curCoords.setCoords(player.curCoords.x, player.curCoords.y - 11);
			player.curGrid.getGrid()[player.curCoords.y][player.curCoords.x] = '#';
		}
		player.updateCurTxtArea();
		player.updatePlayerSurroundings();
	}
	
	public void left()
	{
		LocationType moveTo = player.getSurroundings()[3];
		if(moveTo == LocationType.SPACE)
		{
			player.curGrid.getGrid()[player.curCoords.y][player.curCoords.x] = ' ';
			player.curCoords.setCoords(player.curCoords.x - 1, player.curCoords.y);
			player.curGrid.getGrid()[player.curCoords.y][player.curCoords.x] = '#';
		}
		else if(moveTo == LocationType.OTHER_GRID)
		{
			player.curGrid.getGrid()[player.curCoords.y][player.curCoords.x] = ' ';
			player.updateCurTxtArea();
			player.curGridNum = maze.getGridNumRelative(Controls.LEFT_ACTION, player.curGridNum);
			player.curGrid = maze.getGrid(player.curGridNum);
			player.curCoords.setCoords(player.curCoords.x + 11, player.curCoords.y);
			player.curGrid.getGrid()[player.curCoords.y][player.curCoords.x] = '#';
		}
		player.updateCurTxtArea();
		player.updatePlayerSurroundings();
	}
	
	public void right()
	{
		LocationType moveTo = player.getSurroundings()[4];
		if(moveTo == LocationType.SPACE)
		{
			player.curGrid.getGrid()[player.curCoords.y][player.curCoords.x] = ' ';
			player.curCoords.setCoords(player.curCoords.x + 1, player.curCoords.y);
			player.curGrid.getGrid()[player.curCoords.y][player.curCoords.x] = '#';
		}
		else if(moveTo == LocationType.OTHER_GRID)
		{
			player.curGrid.getGrid()[player.curCoords.y][player.curCoords.x] = ' ';
			player.updateCurTxtArea();
			player.curGridNum = maze.getGridNumRelative(Controls.RIGHT_ACTION, player.curGridNum);
			player.curGrid = maze.getGrid(player.curGridNum);
			player.curCoords.setCoords(player.curCoords.x - 11, player.curCoords.y);
			player.curGrid.getGrid()[player.curCoords.y][player.curCoords.x] = '#';
		}
		player.updateCurTxtArea();
		player.updatePlayerSurroundings();
	}
}
