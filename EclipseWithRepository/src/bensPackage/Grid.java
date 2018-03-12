package bensPackage;

import java.util.ArrayList;

public class Grid {
	
	public static final char FILLER_CHAR = ' ';
	private char[][] grid;
	private boolean top;
	private boolean bottom;
	private boolean left;
	private boolean right;
	
	public Grid()
	{
		//initializes grid 2d array
		grid = new char[12][12];
		for(int i = 0; i < 12; i++)
		{
			for(int j = 0; j < 12; j++)
			{
				grid[i][j] = (' ');
			}
		}
		this.top = false;
		this.bottom = false;
		this.left = false;
		this.right = false;
	}
	
	public Grid(String input)
	{
		grid = new char[12][12];
		int curIndex = 0;
		for(int i = 0; i < 12; i++)
		{
			for(int j = 0; j < 12; j++)
			{
				grid[i][j] = Chunk.intCharToChar(input.charAt(curIndex));
				curIndex++;
			}
		}
	}
	
	public char[][] getGrid()
	{
		return this.grid;
	}
	
	public void localPrintGrid()
	{
		for(int i = 0; i < 12; i++)
		{
			for(int j = 0; j < 12; j++)
			{
				System.out.print(grid[i][j]);
				System.out.print(FILLER_CHAR);
			}
			System.out.println();
		}
	}
	
	public void getEntrances(ArrayList<Grid> arrayList)
	{
		Grid curGrid;
		for(int i = 0; i < arrayList.size(); i++)
		{
			curGrid = arrayList.get(i);
			getEntrances(curGrid);
		}
	}
	
	public void getEntrances(Grid input)
	{
		if(input.hasTop())
		{
			input.top = true;
		}
		if(input.hasBottom())
		{
			input.bottom = true;
		}
		if(input.hasLeft())
		{
			input.left = true;
		}
		if(input.hasRight())
		{
			input.right = true;
		}
	}
	
	public boolean hasTop()
	{
		if(this.grid[0][5] == ' ')
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public boolean hasBottom()
	{
		if(this.grid[11][5] == ' ')
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public boolean hasLeft()
	{
		if(this.grid[5][0] == ' ')
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public boolean hasRight()
	{
		if(grid[5][11] == ' ')
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	public void printOpenings(ArrayList<Grid> input)
	{
		Grid curGrid;
		for(int i = 0; i < input.size(); i++)
		{
			curGrid = input.get(i);
			printOpenings(curGrid);
		}
	}
	
	public void printOpenings(Grid input)
	{
		System.out.println("Has top: " + input.top);
		System.out.println("Has bottom: " + input.bottom);
		System.out.println("Has left: " + input.left);
		System.out.println("Has right: " + input.right);
	}
	
	public boolean hasTopEz()
	{
		return this.top;
	}
	
	public boolean hasBottomEz()
	{
		return this.bottom;
	}
	
	public boolean hasLeftEz()
	{
		return this.left;
	}
	
	public boolean hasRightEz()
	{
		return this.right;
	}
	
	public String getString()
	{
		String returnString = "";
		for(int i = 0; i < grid.length; i++)
		{
			for(int j = 0; j < grid[i].length; j++)
			{
				returnString = returnString + grid[i][j];
				if(!(j == grid[i].length - 1))
				{
					returnString = returnString + " ";
				}
			}
			if(!(i == grid.length - 1))
			{
				returnString = returnString + "\n";
			}
		}
		
		return returnString;
	}
	
	public String getRow(int rowNum)
	{
		String returnString = "";
		for(int i = 0; i < this.grid[rowNum].length; i++)
		{
			returnString = returnString + grid[rowNum][i];
		}
		
		return returnString;
	}
}











