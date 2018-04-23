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
		
		System.out.println(direction);
	}
	
	public void up()
	{
		if(player.getSurroundings()[6] == LocationType.SPACE)
		{
			player.curGrid.getGrid()[player.curCoords.y][player.curCoords.x] = ' ';
			player.curCoords.setCoords(player.curCoords.x, player.curCoords.y - 1);
			player.curGrid.getGrid()[player.curCoords.y][player.curCoords.x] = '#';
			player.updateCurTxtArea();
		}
	}
	
	public void down()
	{
		if(player.getSurroundings()[1] == LocationType.SPACE)
		{
			player.curGrid.getGrid()[player.curCoords.y][player.curCoords.x] = ' ';
			player.curCoords.setCoords(player.curCoords.x, player.curCoords.y + 1);
			player.curGrid.getGrid()[player.curCoords.y][player.curCoords.x] = '#';
			player.updateCurTxtArea();
		}
	}
	
	public void left()
	{
		if(player.getSurroundings()[3] == LocationType.SPACE)
		{
			player.curGrid.getGrid()[player.curCoords.y][player.curCoords.x] = ' ';
			player.curCoords.setCoords(player.curCoords.x - 1, player.curCoords.y);
			player.curGrid.getGrid()[player.curCoords.y][player.curCoords.x] = '#';
			player.updateCurTxtArea();
		}
	}
	
	public void right()
	{
		if(player.getSurroundings()[4] == LocationType.SPACE)
		{
			player.curGrid.getGrid()[player.curCoords.y][player.curCoords.x] = ' ';
			player.curCoords.setCoords(player.curCoords.x + 1, player.curCoords.y);
			player.curGrid.getGrid()[player.curCoords.y][player.curCoords.x] = '#';
			player.updateCurTxtArea();
		}
	}
}
