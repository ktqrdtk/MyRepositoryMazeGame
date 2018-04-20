package bensPackage;

@SuppressWarnings("unused")
public class Maze {
	
	private int numOfGrids;
	private Grid[][] maze;
	private int fontSize;
	private int size;
	
	public Maze(int numOfGrids)
	{
		this.numOfGrids = numOfGrids;
		this.size = (int)Math.sqrt(numOfGrids);
		Generator myGen = new Generator();
		maze = myGen.setMaze(numOfGrids);
		if(getSize() == 1)
		{
			fontSize = 60;
		}
		else if(getSize() == 2)
		{
			fontSize = 28;
		}
		else if(getSize() == 3)
		{
			fontSize = 18;
		}
		else
		{
			fontSize = 15;
		}
	}
	
	public Grid[][] getMaze()
	{
		return maze;
	}
	
	public int getSize()
	{
		return this.size;
	}
	
	public int getNumOfGrids()
	{
		return this.numOfGrids;
	}
	
	public String getString(int location, boolean hasSpaces)
	{
		String returnString = "";
		char[][] thisGrid = this.getGrid(location).getGrid();
		for(int i = 0; i < thisGrid.length; i++)
		{
			for(int j = 0; j < thisGrid[i].length; j++)
			{
				returnString += thisGrid[i][j];
				if(hasSpaces && j < (thisGrid[i].length - 1))
				{
					returnString += " ";
				}
			}
			if(i < (thisGrid.length - 1))
			{
				returnString += "\n";
			}
		}
		return returnString;
	}
	
	public int getFontSize()
	{
		return this.fontSize;
	}
	
	public Grid getGrid(int location)
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
		return maze[y][x];
	}
	
	public int getMiddleGridNum()
	{
		switch(this.size)
		{
		case 1:
			return 0;
		case 3:
			return 4;
		default:
			return -1;
		}
	}
	
}
