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
		Grid grid00 = getRandomChunkBottomRight();
		Grid grid01 = getRandomChunkLeftBottom();
		Grid grid10 = getRandomChunkTopRight();
		Grid grid11 = getRandomChunkTopLeft();
		theGrid[0][0] = grid00;
		theGrid[0][1] = grid01;
		theGrid[1][0] = grid10;
		theGrid[1][1] = grid11;
		return theGrid;
	}
	
	public Grid[][] maze9()
	{
		Grid[][] theGrid = new Grid[(int)Math.sqrt(this.size)][(int)Math.sqrt(this.size)];
		theGrid[0][0] = getRandomChunkBottomRight();
		theGrid[0][1] = getRandomChunkLeftRight();
		theGrid[0][2] = getRandomChunkLeftBottom();
		theGrid[1][0] = getRandomChunkTopBottom();
		theGrid[1][1] = getDefaultChunk();
		theGrid[1][2] = getRandomChunkTopBottom();
		theGrid[2][0] = getRandomChunkTopRight();
		theGrid[2][1] = getRandomChunkLeftRight();
		theGrid[2][2] = getRandomChunkTopLeft();
		
		return theGrid;
	}
	
	public Grid[][] maze16()
	{
		Grid[][] theGrid = new Grid[(int)Math.sqrt(this.size)][(int)Math.sqrt(this.size)];
		return theGrid;
	}
	
	public static Grid getDefaultChunk()
	{
		ArrayList<Grid> list = MazeReader.listOfGrids;
		Grid defaultGrid = list.get(list.size() - 1);
		//System.out.println((defaultGrid.getString()));
		return list.get(list.size() - 1);
	}
	
	public static Grid getRandomChunk()
	{
		Random randomizer = new Random();
		int randomIndex = randomizer.nextInt(MazeReader.listOfGrids.size());
		Grid randomGrid = MazeReader.listOfGrids.get(randomIndex);
		return randomGrid;
	}
	
	public static Grid getRandomChunkTopBottom()
	{
		return getRandomChunk(true, true, false, false);
	}
	
	public static Grid getRandomChunkTopLeft()
	{
		return getRandomChunk(true, false, true, false);
	}
	
	public static Grid getRandomChunkTopRight()
	{
		return getRandomChunk(true, false, false, true);
	}
	
	public static Grid getRandomChunkLeftRight()
	{
		return getRandomChunk(false, false, true, true);
	}
	
	public static Grid getRandomChunkLeftBottom()
	{
		return getRandomChunk(false, true, true, false);
	}
	
	public static Grid getRandomChunkBottomRight()
	{
		return getRandomChunk(false, true, false, true);
	}
	
	public static Grid getRandomChunk(boolean top, boolean bottom, boolean left, boolean right)

	{
		Random randomizer = new Random();
		String requirements = "";
		if(top)
		{
			requirements+= "top ";
		}
		if(bottom)
		{
			requirements+= "bottom ";
		}
		if(left)
		{
			requirements+= "left ";
		}
		if(right)
		{
			requirements+= "right ";
		}
		
		//makes it so that the random grids don't retry already tested grids
		ArrayList<Integer> listOfUnusedIndexes = new ArrayList<Integer>();
		/*
		for(int i = 0; i < MazeReader.listOfGrids.size(); i++)
		{
			listOfUnusedIndexes.add(i);
		}
		*/
		//not this^^ anymore because of defaultmaze, remember all your code that has anything to do with this will break if you add default maze somewhere to the list besides last.
		for(int i = 1; i < MazeReader.listOfGrids.size() - 1; i++)
		{
			listOfUnusedIndexes.add(i - 1);
		}
		int randomIndexForIndexes;
		int randomIndex;
		Grid randomGrid = MazeReader.listOfGrids.get(0);
		
		if(top && bottom)
		{
			while(!(randomGrid.hasTopEz() && randomGrid.hasBottomEz()))
			{
				try
				{
					randomIndexForIndexes = randomizer.nextInt(listOfUnusedIndexes.size());
					randomIndex = listOfUnusedIndexes.get(randomIndexForIndexes);
					listOfUnusedIndexes.remove(randomIndexForIndexes);
					randomGrid = MazeReader.listOfGrids.get(randomIndex);
				}
				catch(Exception ex)
				{
					System.out.println("No grids apply, requirements: " + requirements);
					randomGrid = MazeReader.listOfGrids.get(0);
					break;
				}
			}
		}
		else if(top && left)
		{
			while(!(randomGrid.hasTopEz() && randomGrid.hasLeftEz()))
			{
				try
				{
					randomIndexForIndexes = randomizer.nextInt(listOfUnusedIndexes.size());
					randomIndex = listOfUnusedIndexes.get(randomIndexForIndexes);
					listOfUnusedIndexes.remove(randomIndexForIndexes);
					randomGrid = MazeReader.listOfGrids.get(randomIndex);
				}
				catch(Exception ex)
				{
					System.out.println("No grids apply, requirements: " + requirements);
					randomGrid = MazeReader.listOfGrids.get(0);
					break;
				}
			}
		}
		else if(top && right)
		{
			while(!(randomGrid.hasTopEz() && randomGrid.hasRightEz()))
			{
				try
				{
					randomIndexForIndexes = randomizer.nextInt(listOfUnusedIndexes.size());
					randomIndex = listOfUnusedIndexes.get(randomIndexForIndexes);
					listOfUnusedIndexes.remove(randomIndexForIndexes);
					randomGrid = MazeReader.listOfGrids.get(randomIndex);
				}
				catch(Exception ex)
				{
					System.out.println("No grids apply, requirements: " + requirements);
					randomGrid = MazeReader.listOfGrids.get(0);
					break;
				}
			}
		}
		else if(bottom && left)
		{
			while(!(randomGrid.hasBottomEz() && randomGrid.hasLeftEz()))
			{
				try
				{
					randomIndexForIndexes = randomizer.nextInt(listOfUnusedIndexes.size());
					randomIndex = listOfUnusedIndexes.get(randomIndexForIndexes);
					listOfUnusedIndexes.remove(randomIndexForIndexes);
					randomGrid = MazeReader.listOfGrids.get(randomIndex);
				}
				catch(Exception ex)
				{
					System.out.println("No grids apply, requirements: " + requirements);
					randomGrid = MazeReader.listOfGrids.get(0);
					break;
				}
			}
		}
		else if(bottom && right)
		{
			while(!(randomGrid.hasBottomEz() && randomGrid.hasRightEz()))
			{
				try
				{
					randomIndexForIndexes = randomizer.nextInt(listOfUnusedIndexes.size());
					randomIndex = listOfUnusedIndexes.get(randomIndexForIndexes);
					listOfUnusedIndexes.remove(randomIndexForIndexes);
					randomGrid = MazeReader.listOfGrids.get(randomIndex);
				}
				catch(Exception ex)
				{
					System.out.println("No grids apply, requirements: " + requirements);
					randomGrid = MazeReader.listOfGrids.get(0);
					break;
				}
			}
		}
		else if(right && left)
		{
			while(!(randomGrid.hasRightEz() && randomGrid.hasLeftEz()))
			{
				try
				{
					randomIndexForIndexes = randomizer.nextInt(listOfUnusedIndexes.size());
					randomIndex = listOfUnusedIndexes.get(randomIndexForIndexes);
					listOfUnusedIndexes.remove(randomIndexForIndexes);
					randomGrid = MazeReader.listOfGrids.get(randomIndex);
				}
				catch(Exception ex)
				{
					System.out.println("No grids apply, requirements: " + requirements);
					randomGrid = MazeReader.listOfGrids.get(0);
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
