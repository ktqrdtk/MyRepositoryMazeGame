package bensPackage;

@SuppressWarnings("unused")
public class Maze {
	
	private int numOfGrids;
	private Grid[][] maze;
	
	public Maze(int numOfGrids)
	{
		this.numOfGrids = numOfGrids;
		Generator myGen = new Generator();
		maze = myGen.setMaze(numOfGrids);
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
		for(int i = 0; i < this.getGrid(location).getGrid().length; i++)
		{
			for(int j = 0; j < this.getGrid(location).getGrid()[i].length; j++)
			{
				returnString += this.getGrid(location).getGrid()[i][j];
				if(hasSpaces && j < (this.getGrid(location).getGrid()[i].length - 1))
				{
					returnString += " ";
				}
			}
			if(i < (this.getGrid(location).getGrid().length - 1))
			{
				returnString += "\n";
			}
		}
		
		return returnString;
	}
	
	public int getFontSize()
	{
		if(this.getSize() == 1)
		{
			return 48;
		}
		else
		{
			return 24;
		}
	}
	
	public Grid getGrid(int location)
	{
		if(this.getSize() == 1)
		{
			return maze[0][0];
		}
		else if(this.getSize() == 2)
		{
			if(location == 0)
			{
				return maze[0][0];
			}
			else if(location == 1)
			{
				return maze[0][1];
			}
			else if(location == 2)
			{
				return maze[1][0];
			}
			else if(location == 3)
			{
				return maze[1][1];
			}
		}
		else if(this.getSize() == 3)
		{
			if(location == 0)
			{
				return maze[0][0];
			}
			else if(location == 1)
			{
				return maze[0][1];
			}
			else if(location == 2)
			{
				return maze[0][2];
			}
			else if(location == 3)
			{
				return maze[1][0];
			}
			else if(location == 4)
			{
				return maze[1][1];
			}
			else if(location == 5)
			{
				return maze[1][2];
			}
			else if(location == 6)
			{
				return maze[2][0];
			}
			else if(location == 7)
			{
				return maze[2][1];
			}
			else if(location == 8)
			{
				return maze[2][2];
			}
		}
		return null;
		
	}
	
}
