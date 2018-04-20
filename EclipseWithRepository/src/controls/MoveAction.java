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
		
		player.updateCurTxtArea();
	}
	
	public void down()
	{
		player.updateCurTxtArea();
	}
	
	public void left()
	{
		player.updateCurTxtArea();
	}
	
	public void right()
	{
		player.updateCurTxtArea();
	}
}
