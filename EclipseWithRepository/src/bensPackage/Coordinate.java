package bensPackage;

public class Coordinate 
{
	public int x;
	public int y;
	
	public Coordinate()
	{
		this(0, 0);
	}
	
	public Coordinate(int x, int y)
	{
		this.x = x;
		this.y = y;
	}
	
	public void setX(int x)
	{
		this.x = x;
	}
	
	public void setY(int y)
	{
		this.y = y;
	}
	
	public void setCoords(int x, int y)
	{
		this.x = x;
		this.y = y;
	}
	
	public int getX()
	{
		return this.x;
	}
	
	public int getY()
	{
		return this.y;
	}
	
	@Override
	public String toString()
	{
		return "X: " + this.x + " Y: " + this.y;
	}
	
	@Override
	public boolean equals(Object obj)
	{
		if(obj instanceof Coordinate)
		{
			if(((Coordinate)obj).x == this.x && this.y == ((Coordinate)obj).y)
			{
				return true;
			}
			else
			{
				return false;
			}
		}
		else
		{
			return super.equals(obj);
		}
	}
	
	public static Coordinate getCoords(int location, int size)
	{
		int x = 0;
		int y = 0;
		for(int i = 0; i < location; i++)
		{
			x++;
		}
		while(x >= size)
		{
			x-= size;
			y++;
		}
		return new Coordinate(x, y);
	}
}
