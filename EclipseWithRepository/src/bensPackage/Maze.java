package bensPackage;

import java.util.Random;

public class Maze {
	
	private int numOfGrids;
	private Grid[][] maze;
	
	public Maze(int numOfGrids)
	{
		this.numOfGrids = numOfGrids;
	}
	
	public void makeMaze(int numOfGrids)
	{
		Random randomizer = new Random();
		int randomIndex = randomizer.nextInt(MazeReader.listOfGrids.size());
		
		if(numOfGrids == 1)
		{
			MazeReader.listOfGrids.get(randomIndex);
		}
	}
	
}
