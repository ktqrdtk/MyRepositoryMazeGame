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
		this.direction = direction;
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		System.out.println(direction);
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
		System.out.println(player.getSurroundings()[6] + " Up Executed");
		if(player.getSurroundings()[6] == LocationType.SPACE)
		{
			player.curGrid.getGrid()[player.curCoords.y][player.curCoords.x] = ' ';
			player.curCoords.setCoords(player.curCoords.x, player.curCoords.y - 1);
			player.curGrid.getGrid()[player.curCoords.y][player.curCoords.x] = '#';
			player.updateCurTxtArea();
			player.updatePlayerSurroundings();
		}
	}
	
	public void down()
	{
		System.out.println(player.getSurroundings()[1] + " Down Executed");
		if(player.getSurroundings()[1] == LocationType.SPACE)
		{
			player.curGrid.getGrid()[player.curCoords.y][player.curCoords.x] = ' ';
			player.curCoords.setCoords(player.curCoords.x, player.curCoords.y + 1);
			player.curGrid.getGrid()[player.curCoords.y][player.curCoords.x] = '#';
			player.updateCurTxtArea();
			player.updatePlayerSurroundings();
		}
	}
	
	public void left()
	{
		System.out.println(player.getSurroundings()[3] + " Left Executed");
		if(player.getSurroundings()[3] == LocationType.SPACE)
		{
			player.curGrid.getGrid()[player.curCoords.y][player.curCoords.x] = ' ';
			player.curCoords.setCoords(player.curCoords.x - 1, player.curCoords.y);
			player.curGrid.getGrid()[player.curCoords.y][player.curCoords.x] = '#';
			player.updateCurTxtArea();
			player.updatePlayerSurroundings();
		}
	}
	
	public void right()
	{
		System.out.println(player.getSurroundings()[4] + " Right Executed");
		if(player.getSurroundings()[4] == LocationType.SPACE)
		{
			player.curGrid.getGrid()[player.curCoords.y][player.curCoords.x] = ' ';
			player.curCoords.setCoords(player.curCoords.x + 1, player.curCoords.y);
			player.curGrid.getGrid()[player.curCoords.y][player.curCoords.x] = '#';
			player.updateCurTxtArea();
			player.updatePlayerSurroundings();
		}
	}
}
