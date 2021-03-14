import java.util.Scanner;

public class Board {
   
	private int rows;
    private int columns;
	private char [][]   arraychips_players;
	private int [] row;
	
	//This method is constructor without parameters.
	public Board()
	{
		rows = 0;
		columns = 0;
	}
	
	// This method is constructor with parameters.
	public Board(int r, int c)
	{
		rows= r;
		columns= c;
		arraychips_players = new char [rows][columns];
	    row = new int [columns];
	}
	
	// These methods are setters.
	public void setRows(int r) { rows = r;}
	public void setColumns(int c) { rows = c;}
	public void setArrayChips_Players(char[][] array) {  arraychips_players = array;}
	public void setRow(int [] array) {  row = array;}
	public void setRowi(int i) { row[i]--;}  // This method decreases by 1 the content of row[i].
	
	// These methods are getters.
	public int getRows() { return rows;}
	public int getColumns() { return columns;}
	public char[][] getArrayChips_Players() { return arraychips_players;}
	public int[] getRow() { return row;}
	public int getRowi(int i) {return row[i];} // This method give the i element of row.
	
	// This method reads the rows and columns from keyboard.
	public void giveRowsColumns(Scanner input)
	{
		do
		{
			System.out.print("Please enter the number of rows ( 4=<rows<=15 ) : ");
		    rows = input.nextInt();
		    if(rows<4 || rows>15)
		    {
		    	System.out.println("Incorrect input.");
		    }
		}while(rows<4 || rows>15);
		
		do
	    {
			System.out.print("Please enter the number of columns ( 4=<columns<=15 ) : ");	
	        columns = input.nextInt();
	         if( columns<4 || columns>15)
			 {
				System.out.print("Incorrect input.");
             }
	    }while(columns<4 || columns>15);
		arraychips_players = new char [rows][columns];
		row = new int [columns];
	}
	
	// This method complete the arraychips_players with '-'.
	public void completeArrayChips_Players()
	{
		for(int i=0; i<rows; i++)
	      {
	    	  for(int j=0; j<columns; j++)
	    	  {
	    		  arraychips_players[i][j]='-';
	    	  }
	      }
	}
	
	
	//This method prints the arraychip_player.
    public void printArrayChip_Players()
    {
    	System.out.println();
		for(int i=0; i<rows; i++)
	    {
			 System.out.print("|  ");
		     for(int j=0; j<columns; j++)
		     {
		         System.out.print(arraychips_players[i][j] + "  ");
		     }
		    System.out.println("|");
		}
			 
		for(int i=0 ;i<3*columns+4; i++)
	    {
			 System.out.print("-");
		}
		System.out.println("");
	    System.out.print("   ");
	    int sum=1;
	    for(int i=4 ;i<=3*columns+2; i=i+3)
	    {
	        if(sum<=9)
		    {
	        	System.out.print(sum + "  ");
				sum++; 
			}
			else
			{
				System.out.print(sum + " ");
			    sum++;
			}
	     }
	    System.out.println();
	   }
		
	// This method completes the raw with rows - 1. 
	public void completeRow()
	{
		for(int i=0; i<columns; i++)
	    {
		    row[i] = rows - 1;
		}
	}
		
	//This method pushes the chip of the player in the arraychips_players.
	public void push_ChipPlayer(int r , char arraychips_players[][], player p)
	{
		arraychips_players[r][p.getSelect_column() - 1] =  p.getChip();
	}
}
