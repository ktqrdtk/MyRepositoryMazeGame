package bensPackage;

import java.util.ArrayList;
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
				
			case 4 :
				maze4();
				break;
				
			case 9 :
				maze9();
				break;
				
			case 16 :
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
		
		//makes it so that the random grids don't retry already tested grids
		ArrayList<Integer> listOfUnusedIndexes = new ArrayList<Integer>();
		for(int i = 0; i < MazeReader.listOfGrids.size(); i++)
		{
			listOfUnusedIndexes.add(i);
		}	
		int randomIndexForIndexes;
		int randomIndex;
		Grid randomGrid = MazeReader.listOfGrids.get(0);
		
		if(top && bottom)
		{
			while(!(randomGrid.hasTopEz() && randomGrid.hasBottomEz()))
			{
				randomIndexForIndexes = randomizer.nextInt(listOfUnusedIndexes.size());
				randomIndex = listOfUnusedIndexes.get(randomIndexForIndexes);
				listOfUnusedIndexes.remove(randomIndexForIndexes);
				try
				{
					randomGrid = MazeReader.listOfGrids.get(randomIndex);
				}
				catch(IndexOutOfBoundsException ex)
				{
					System.out.println("No grids apply");
					break;
				}
			}
		}
		else if(top && left)
		{
			while(!(randomGrid.hasTopEz() && randomGrid.hasLeftEz()))
			{
				randomIndexForIndexes = randomizer.nextInt(listOfUnusedIndexes.size());
				randomIndex = listOfUnusedIndexes.get(randomIndexForIndexes);
				listOfUnusedIndexes.remove(randomIndexForIndexes);
				try
				{
					randomGrid = MazeReader.listOfGrids.get(randomIndex);
				}
				catch(IndexOutOfBoundsException ex)
				{
					System.out.println("No grids apply");
					break;
				}
			}
		}
		else if(top && right)
		{
			while(!(randomGrid.hasTopEz() && randomGrid.hasRightEz()))
			{
				randomIndexForIndexes = randomizer.nextInt(listOfUnusedIndexes.size());
				randomIndex = listOfUnusedIndexes.get(randomIndexForIndexes);
				listOfUnusedIndexes.remove(randomIndexForIndexes);
				try
				{
					randomGrid = MazeReader.listOfGrids.get(randomIndex);
				}
				catch(IndexOutOfBoundsException ex)
				{
					System.out.println("No grids apply");
					break;
				}
			}
		}
		else if(bottom && left)
		{
			while(!(randomGrid.hasBottomEz() && randomGrid.hasLeftEz()))
			{
				randomIndexForIndexes = randomizer.nextInt(listOfUnusedIndexes.size());
				randomIndex = listOfUnusedIndexes.get(randomIndexForIndexes);
				listOfUnusedIndexes.remove(randomIndexForIndexes);
				try
				{
					randomGrid = MazeReader.listOfGrids.get(randomIndex);
				}
				catch(IndexOutOfBoundsException ex)
				{
					System.out.println("No grids apply");
					break;
				}
			}
		}
		else if(bottom && right)
		{
			while(!(randomGrid.hasBottomEz() && randomGrid.hasRightEz()))
			{
				randomIndexForIndexes = randomizer.nextInt(listOfUnusedIndexes.size());
				randomIndex = listOfUnusedIndexes.get(randomIndexForIndexes);
				listOfUnusedIndexes.remove(randomIndexForIndexes);
				try
				{
					randomGrid = MazeReader.listOfGrids.get(randomIndex);
				}
				catch(IndexOutOfBoundsException ex)
				{
					System.out.println("No grids apply");
					break;
				}
			}
		}
		else if(right && left)
		{
			while(!(randomGrid.hasRightEz() && randomGrid.hasLeftEz()))
			{
				randomIndexForIndexes = randomizer.nextInt(listOfUnusedIndexes.size());
				randomIndex = listOfUnusedIndexes.get(randomIndexForIndexes);
				listOfUnusedIndexes.remove(randomIndexForIndexes);
				try
				{
					randomGrid = MazeReader.listOfGrids.get(randomIndex);
				}
				catch(IndexOutOfBoundsException ex)
				{
					System.out.println("No grids apply");
					break;
				}
			}
		}
		else
		{
			System.out.println("Conditions arent setup correctely");
		}
		
		//deletes list of indexes
		listOfUnusedIndexes = null;
		
		return randomGrid;
	}
}
