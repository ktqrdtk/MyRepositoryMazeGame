package bensPackage;

import java.io.*;
import java.util.ArrayList;

public class MazeReader {
	
	public static ArrayList<Grid> listOfGrids;
	
	public MazeReader(int input)
	{
		
		ArrayList<String> fileNames = new ArrayList<String>();
		addFileNames(input, fileNames);
		listOfGrids = new ArrayList<Grid>();
		int indexOfFile = 0;
		String line = null;
		String gridInStringInt = "";
		char curChar = 'Z';
		int curIndex = 0;
		
		for(int k = 0; k < fileNames.size(); k++)
		{
			try
			{
				FileReader fileReader = new FileReader(fileNames.get(indexOfFile));
				
				BufferedReader bufferedReader = new BufferedReader(fileReader);
				
				while((line = bufferedReader.readLine()) != null)
				{
					curIndex = 0;
					for(int f = 0; f < line.length(); f++)
					{
						curChar = line.charAt(curIndex);
						gridInStringInt = gridInStringInt + String.valueOf((Chunk.charToInt(curChar)));
						curIndex++;
					}
				}
				Grid curGrid = new Grid(gridInStringInt);
				listOfGrids.add(curGrid);
				
				bufferedReader.close();
				
				gridInStringInt = "";
				curGrid = null;
				fileReader = null;
				bufferedReader = null;
				indexOfFile++;
			}
			catch(FileNotFoundException ex)
			{
				System.out.println("Unable to open file: '" + fileNames.get(indexOfFile) + "'");
			}
			catch(IOException ex)
			{
				System.out.println("Error reading file: '" + fileNames.get(indexOfFile) + "'");
			}
		}
		
		Grid.getEntrances(listOfGrids);
	}
	
	public void addFileNames(int input, ArrayList<String> arrayList)
	{
		String currentFileName;
		//its input - 1 because the default maze would up the number which we dont want
		for(int i = 0; i < input - 1; i++)
		{
			currentFileName = "MazesFolder//Maze" + i + ".txt";
			arrayList.add(currentFileName);
		}
		
		currentFileName = "MazesFolder//DefaultMaze.txt";
		arrayList.add(currentFileName);
	}
	
	public static void myPrint(ArrayList<String> input)
	{
		for(int i = 0; i < input.size(); i++)
		{
			System.out.println(input.get(i));
		}
	}
	
}
