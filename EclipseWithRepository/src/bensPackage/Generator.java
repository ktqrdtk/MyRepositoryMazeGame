package bensPackage;

import java.util.Random;

public class Generator {
	
	private int size;
	private int chunks;
	
	public Generator(int chunks)
	{
		this.chunks = chunks;
		this.size = this.chunks * 12;
		chunkGenerator();
	}
	
	public void combine()
	{
		
	}
	
	public void chunkGenerator()
	{
		switch(this.chunks)
		{
			case 1 :
				maze1();
				break;
				
			case 4:
				maze4();
				break;
				
			case 9:
				maze9();
				break;
				
			case 16:
				maze16();
				break;
				
			default :
				maze1();
		}
	}
	
	public void maze1()
	{
		Grid grid00 = getRandomChunk();
	}
	
	public void maze4()
	{
		
	}
	
	public void maze9()
	{
		
	}
	
	public void maze16()
	{
		
	}
	
	public Grid getRandomChunk()
	{
		Random randomizer = new Random();
		int randomIndex = randomizer.nextInt(MazeReader.listOfGrids.size());
		Grid randomGrid = MazeReader.listOfGrids.get(randomIndex);
		return randomGrid;
	}
	
	public Grid getRandomChunk(boolean top, boolean bottom, boolean left, boolean right)
	{
		Random randomizer = new Random();
		int randomIndex = randomizer.nextInt(MazeReader.listOfGrids.size());
		
	}
}
