package bensPackage;

public class MazeGame {
	
	private MazeReader mazeReader;

	public static void main(String[] args) {
		//tempDecomp();
		//tempComp();
		MazeGame mzGm = new MazeGame();
		int totalNumOfMazesInFile = 4;
		mzGm.readFile(totalNumOfMazesInFile);
	}
	
	public static void tempDecomp()
	{
		String firstNumberSet = Chunk.chunks[0];
		Grid firstGrid = Chunk.chunkDeconverter(firstNumberSet);
		firstGrid.localPrintGrid();
	}
	
	
	public static void tempComp()
	{
		Chunk.chunkConverter();
	}
	
	public void readFile(int input)
	{
		mazeReader = new MazeReader(input);
	}

}