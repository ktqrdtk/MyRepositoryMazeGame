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
		else
		{
			fontSize = 18;
		}
	}
	
	public Grid[][] getMaze()
	{
		return maze;
	}
	
	/*public String getString(boolean hasSpaces)
	{
		String mazeInString = "";
			for(int i = 0; i < maze.length; i++)
			{
				for(int j = 0; j < maze[i].length; j++)
				{
					for(int k = 0; k < maze[i][j].getGrid().length; k++)
					{
						for(int l = 0; l < maze[i][j].getGrid()[k].length; l++)
						{
							mazeInString = mazeInString + maze[i][j].getGrid()[k][l];
							if((l < maze[i][j].getGrid()[k].length - 1) && hasSpaces)
							{
								mazeInString += " ";
							}
						}
						if((k < (maze[i][j].getGrid().length - 1)) || j < maze[i].length)
						{
							mazeInString += "\n";
						}
					}
				}
			}
		return mazeInString;
	}*/
	
	public int getSize()
	{
		return (int)Math.sqrt(this.numOfGrids);
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
	
}
