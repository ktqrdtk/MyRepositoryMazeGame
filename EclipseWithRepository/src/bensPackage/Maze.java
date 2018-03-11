package bensPackage;

@SuppressWarnings("unused")
public class Maze {
	
	private int numOfGrids;
	private Grid[][] maze;
	String mazeInString;
	
	public Maze(int numOfGrids)
	{
		this.numOfGrids = numOfGrids;
		Generator myGen = new Generator();
		maze = myGen.setMaze(numOfGrids);
	}
	
	public String getString()
	{
		mazeInString = "";
		for(int i = 0; i < maze.length; i++)
		{
			for(int j = 0; j < maze.length; j++)
			{
				mazeInString = mazeInString + maze[i][j] + " ";
			}
		}
		return mazeInString;
	}
	
}
