package bensPackage;

import java.util.ArrayList;
import java.util.Random;

@SuppressWarnings("unused")
public class Generator {
	
	private int size;
	//don't use these four without resetting them to random
	private boolean left;
	private boolean right;
	private boolean top;
	private boolean bottom;
	
	public void combine()
	{
		
	}
	
	public Grid[][] setMaze(int size)
	{
		this.size = size;
		Grid[][] theMaze = new Grid[(int)Math.sqrt(this.size)][(int)Math.sqrt(this.size)];
		switch(size)
		{
			case 1 :
				theMaze = maze1();
				break;
				
			case 4 :
				theMaze = maze4();
				break;
				
			case 9 :
				theMaze = maze9();
				break;
				
			case 16 :
				theMaze = maze16();
				break;
				
			default :
				theMaze = maze1();
		}
		
		return theMaze;
	}
	 
	public Grid[][] maze1()
	{
		Grid[][] theGrid = new Grid[(int)Math.sqrt(this.size)][(int)Math.sqrt(this.size)];
		Grid grid00 = getRandomChunk();
		theGrid[0][0] = grid00;
		return theGrid;
	}
	
	public Grid[][] maze4()
	{
		Grid[][] theGrid = new Grid[(int)Math.sqrt(this.size)][(int)Math.sqrt(this.size)];
		Grid grid00 = getRandomChunk(false, true, false, true);
		Grid grid01 = getRandomChunk(false, true, true, false);
		Grid grid10 = getRandomChunk(true, false, false, true);
		Grid grid11 = getRandomChunk(true, false, true, false);
		theGrid[0][0] = grid00;
		theGrid[0][1] = grid01;
		theGrid[1][0] = grid10;
		theGrid[1][1] = grid11;
		return theGrid;
	}
	
	public Grid[][] maze9()
	{
		Grid[][] theGrid = new Grid[(int)Math.sqrt(this.size)][(int)Math.sqrt(this.size)];
		return theGrid;
	}
	
	public Grid[][] maze16()
	{
		Grid[][] theGrid = new Grid[(int)Math.sqrt(this.size)][(int)Math.sqrt(this.size)];
		return theGrid;
	}
	
	public static Grid getRandomChunk()
	{
		Random randomizer = new Random();
		int randomIndex = randomizer.nextInt(MazeReader.listOfGrids.size());
		Grid randomGrid = MazeReader.listOfGrids.get(randomIndex);
		return randomGrid;
	}
	
	public static Grid getRandomChunk(boolean top, boolean bottom, boolean left, boolean right)

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
	
	public void setRandomTwo()
	{
		Random randomizer = new Random();
		int randomInt = randomizer.nextInt(6);
		switch(randomInt)
		{
		case 0 :
			left = true;
			top = true;
			right = false;
			bottom = false;
			break;
		
		case 1 :
			left = true;
			right = true;
			top = false;
			bottom = false;
			break;
			
		case 2 :
			left = true;
			bottom = true;
			top = false;
			right = false;
			break;
			
		case 3 :
			top = true;
			right = true;
			left = false;
			bottom = false;
			break;
			
		case 4 :
			top = true;
			bottom = true;
			left = false;
			right = false;
			break;
			
		case 5 :
			right = true;
			bottom = true;
			top = false;
			left = false;
			break;
			
		default :
			right = false;
			left = false;
			top = false;
			bottom = false;
		}
	}
}
