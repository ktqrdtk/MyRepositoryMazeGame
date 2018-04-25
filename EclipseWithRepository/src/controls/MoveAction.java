package controls;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import bensPackage.Maze;
import bensPackage.Player;

public class MoveAction extends AbstractAction
{
	private static final long serialVersionUID = 1L;
	private Controls direction;
	public Player player;
	public Maze maze;
	public MoveAction(Controls direction, Player player)
	{
		this.player = player;
		this.maze = player.getMaze();
		this.direction = direction;
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		move(direction);
	}
	
	@SuppressWarnings({ "incomplete-switch", "unused" })
	public void move(Controls methodDirection)
	{
		LocationType moveTo;
		int regularMoveX = 0;
		int regularMoveY = 0;
		int otherGridMoveX = 0;
		int otherGridMoveY = 0;
		switch(methodDirection)
		{
		case RIGHT_ACTION:
			moveTo = player.getSurroundings()[4];
			regularMoveX = 1;
			otherGridMoveX = -11;
			break;
		case LEFT_ACTION:
			moveTo = player.getSurroundings()[3];
			regularMoveX = -1;
			otherGridMoveX = 11;
			break;
		case DOWN_ACTION:
			moveTo = player.getSurroundings()[1];
			regularMoveY = 1;
			otherGridMoveY = -11;
			break;
		default:
			moveTo = player.getSurroundings()[6];
			regularMoveY = -1;
			otherGridMoveY = 11;
			break;
		}
		
		switch(moveTo)
		{
		case SPACE:
			player.curGrid.getGrid()[player.curCoords.y][player.curCoords.x] = ' ';
			player.curCoords.setCoords(player.curCoords.x + regularMoveX, player.curCoords.y + regularMoveY);
			player.curGrid.getGrid()[player.curCoords.y][player.curCoords.x] = Player.PLAYER_ASCII;
			break;
		case OTHER_GRID:
			player.curGrid.getGrid()[player.curCoords.y][player.curCoords.x] = ' ';
			player.updateCurTxtArea();
			player.curGridNum = maze.getGridNumRelative(methodDirection, player.curGridNum);
			player.curGrid = maze.getGrid(player.curGridNum);
			player.curCoords.setCoords(player.curCoords.x + otherGridMoveX, player.curCoords.y + otherGridMoveY);
			player.curGrid.getGrid()[player.curCoords.y][player.curCoords.x] = Player.PLAYER_ASCII;
			break;
		}
		
		player.updateCurTxtArea();
		player.updatePlayerSurroundings();
	}
}
