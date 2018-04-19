package controls;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

public class MoveAction extends AbstractAction
{
	private static final long serialVersionUID = 1L;
	Controls direction;
	public MoveAction(Controls direction)
	{
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
		
	}
	
	public void down()
	{
		
	}
	
	public void left()
	{
		
	}
	
	public void right()
	{
		
	}
}