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
	
	public String getString()
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
						}
					}
				}
			}
		return mazeInString;
	}
	
}
