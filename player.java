import java.util.Scanner;

public class player {
	
	// Those are the properties of the object player.
	private String name;
	private char chip;
	private int select_column;
	
	// This method is the constructor without parameters.
	public player()
	{
		name= " ";
		chip= ' ';
		select_column= -1;
	}
	
	// This method is the constructor with parameters.
	public player(String n, String c, int sc, Board ad)
	{
		name= n;
		chip= 'c';
		select_column= sc;
	}
	
	// These methods are getters.
	public String getName() { return name;}
	public char getChip() { return chip;}
	public int getSelect_column() { return select_column;}
	
	// These methods are setters.
	public void setName(String n) {  name=n;}
	public void setChip(char c) {  chip=c;}
	public void setSelect_column(int sc) {  select_column=sc;}
	
	// This method gives the name of the player. 
	public void giveName(Scanner input, String priority_line_players)
	{
		System.out.print("Please enter the name of " +  priority_line_players + " player : ");
		name = input.nextLine();
	}
	
	//This method selects the chips for the players.
	public void select_chip(Scanner input, player player2)
	{
		do
		{
			System.out.print( name + " please select your chip : " );
		    chip = input.next().charAt(0);
		}while(chip!='x' && chip!='o');
		
		if(chip=='x')
		{
			System.out.println( player2.getName() + " your chip is : o");
			player2.setChip('o');
		}
		else
		{
			System.out.println( player2.getName() + "your chip is : x");
			player2.setChip('x');
		}
	}
	
	//This method selects the column of the player
	public int select_column_player( Scanner input, int c, int row[])
    {
		do
		{
			System.out.print(name + " your turn. Select column: ");	
		    select_column = input.nextInt();
		    if( select_column<1 || select_column>c)
		    {
		    	System.out.print("Incorrect input.");
		    }
		    else
		    {
		       if(row[select_column - 1] < 0)
		       {
		    	   System.out.print("This column is full.");
		       }
		    }
	    }while(select_column<1 || select_column>c || row[select_column - 1] < 0 );
		
		return select_column ;
		}
	   
	    //This method checks the arraychips_player in order to find winner.
		public boolean checkWinnerPlayer(int r, Board board)
		{
			int i=r, sum_chip=1, j;
			boolean  findwinner;
			int columns = board.getColumns();
			int rows = board.getRows();
			char[][] arraychips_players = board.getArrayChips_Players();
			
			// Check right.
			for( j=select_column ; j<columns  ; j++)
			{
			    if((arraychips_players[i][j] != chip) || sum_chip == 4)
			    {
				    		 break;
			    }
				else
				{
					sum_chip++;
				}	
		     }
			
			// Check left.
			for(j=select_column - 2; j>=0 ; j--)
			{
				if((arraychips_players[i][j] != chip) || sum_chip == 4)
			    {
					      break;
		        }
				else
				{
					sum_chip++;
				}
		   }
		   
			if(sum_chip!=4)
		    {
		    	sum_chip=1;
		    	j=select_column - 1;
		    	
		    	// Check up.
		    	for(i=r - 1; i>=0; i--)
				{
					if((arraychips_players[i][j] != chip) || sum_chip == 4)
				    {
						break;
					}
					else
					{
						sum_chip++;
					}
				}
		    	
		    	// Check down.
		    	for(i=r + 1 ; i<rows; i++)
				{
				     if((arraychips_players[i][j] != chip) || sum_chip == 4)
				     {
					        break;
					 }
					 else
					 {
							sum_chip++;
					 }
				 }
		      }
				
			  if(sum_chip!=4)
			  {
				  sum_chip=1;
				  
				  // Check right and up.
				  for(j=select_column, i=r - 1 ; j<columns && i>=0 ; j++, i--)
					{
					    if((arraychips_players[i ][j] != chip) || sum_chip == 4)
				        {
					         break;
					    }
						else
						{
						     sum_chip++;
						}
					 }
				
				    // Check left and down.
					for(j=select_column - 2, i=r + 1 ; j>=0 && i<rows ; j--, i++)
					{
						if(arraychips_players[i][ j] != chip || sum_chip == 4)
				        {
					        break;
					    }
						else
						{
							sum_chip++;
					    }
				    }
			   }
			    	
				
				if(sum_chip!=4)
				{
					sum_chip=1;
					
					// Check left and up.
					for( j=select_column - 2, i=r - 1 ; j>=0 && i>=0 ; j--, i--)
					{
						if((arraychips_players[i ][j] != chip) || sum_chip == 4)
				        {
					        break;
					    }
						else
						{
							sum_chip++;
						}
					}
					
					// Check right and down.
					for(j=select_column, i=r + 1 ; j<columns && i<rows ; j++, i++)
					{
						if((arraychips_players[i ][j] != chip) || sum_chip == 4)
				        {
					        break;
					    }
						else
						{
							sum_chip++;
					    }
					}
		         }
				
				if(sum_chip == 4)
				{
					findwinner = true;
					return findwinner;  
				}
				else
				{
					findwinner = false;
					return findwinner; 
				}
	 }
}
