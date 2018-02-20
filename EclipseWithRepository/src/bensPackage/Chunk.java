package bensPackage;

import java.util.Scanner;

public class Chunk {
	
	public static final String[] chunks = {};
	
	public Chunk()
	{
		
	}
	
	public static int charToInt(char input)
	{
		if(input == 'X')
		{
			return 0;
		}
		else if(input == '|')
		{
			return 1;
		}
		else if(input == ' ')
		{
			return 2;
		}
		else if(input == '-')
		{
			return 3;
		}
		else if(input == 'O')
		{
			return 4;
		}
		else
		{
			return 5;
		}
	}
	
	public static char intCharToChar(char input)
	{
		if(input == '0')
		{
			return 'X';
		}
		else if(input == '1')
		{
			return '|';
		}
		else if(input == '2')
		{
			return ' ';
		}
		else if(input == '3')
		{
			return '-';
		}
		else if(input == '4')
		{
			return 'O';
		}
		else
		{
			return 'Z';
		}
	}
	
	public static void chunkConverter()
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Start");
		System.out.println("A");
		String firstLine = sc.nextLine();
		System.out.println("B");
		String secondLine = sc.nextLine();
		System.out.println("C");
		String thirdLine = sc.nextLine();
		System.out.println("D");
		String fourthLine = sc.nextLine();
		System.out.println("E");
		String fifthLine = sc.nextLine();
		System.out.println("F");
		String sixthLine = sc.nextLine();
		System.out.println("G");
		String seventhLine = sc.nextLine();
		System.out.println("H");
		String eighthLine = sc.nextLine();
		System.out.println("I");
		String ninethLine = sc.nextLine();
		System.out.println("J");
		String tenthLine = sc.nextLine();
		System.out.println("K");
		String eleventhLine = sc.nextLine();
		System.out.println("L");
		String twelfthLine = sc.nextLine();
		System.out.println("End ");
		
		
		System.out.println(firstLine);
		System.out.println(secondLine);
		System.out.println(thirdLine);
		System.out.println(fourthLine);
		System.out.println(fifthLine);
		System.out.println(sixthLine);
		System.out.println(seventhLine);
		System.out.println(eighthLine);
		System.out.println(ninethLine);
		System.out.println(tenthLine);
		System.out.println(eleventhLine);
		System.out.println(twelfthLine);
		sc.close();
		
		char currentChar = 'Z';
		String returnValue = "";
		String currentLine;
		String[] lineArray = {firstLine, secondLine, thirdLine, fourthLine, fifthLine, sixthLine, seventhLine, eighthLine, ninethLine, tenthLine, eleventhLine, twelfthLine};
		int currentCharInInt = charToInt(currentChar);
		
		
		for(int i = 0; i < 12; i++)
		{
			currentLine = lineArray[i];
			for(int f = 0; f < 12; f++)
			{
				currentChar = currentLine.charAt(f);
				currentCharInInt = charToInt(currentChar);
				returnValue = returnValue + Integer.toString(currentCharInInt);
			}
		}
		
		System.out.println(returnValue);
	}
	
	public static Grid chunkDeconverter(String input)
	{
		//converts to symbols
		Grid returnGrid = new Grid();
		String returnString = "";
		for(int i = 0; i < input.length(); i++)
		{
			returnString = returnString + intCharToChar(input.charAt(i));
		}
		
		//adds symbols to grid
		int curIndex = 0;
		for(int i = 0; i < 12; i++)
		{
			for(int j = 0; j < 12; j++)
			{
				returnGrid.getGrid()[i][j] = returnString.charAt(curIndex);
				curIndex++;
			}
		}
		
		return returnGrid;
	}
	

}

//Git Thing