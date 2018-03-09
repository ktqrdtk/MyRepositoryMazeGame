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
	
}
