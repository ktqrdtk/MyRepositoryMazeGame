package controls;

public enum Controls 
{
	UP_ACTION, DOWN_ACTION, LEFT_ACTION, RIGHT_ACTION;
	
	@Override
	public String toString()
	{
		String print = "";
		switch(this)
		{
		case UP_ACTION:
			print = "Up Command";
			break;
		case DOWN_ACTION:
			print = "Down Command";
			break;
		case LEFT_ACTION:
			print = "Left Command";
			break;
		case RIGHT_ACTION:
			print = "Right Command";
			break;
		default:
			print = "Some Move Action without associated Command";
		}
		return print;
	}
}
