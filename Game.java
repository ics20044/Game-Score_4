import java.util.Random;
import java.util.Scanner;

public class Game {
	
	// Those are the properties of the object game.
    private player player1; // This property is mentioned to class Player.
    private player player2; // This property is mentioned to class Player.
    private Board  arrayedit; // This property is mentioned to class Board
    
    
    // This method is the constructor without parameters.
    public Game()
    {
    	 player1 = new player(); // Create the object player1.
	     player2 = new player(); // Create the object player2.
	     arrayedit = new Board(); // Create the object arrayedit.
    }
    
    // This method is the constructor with parameters.
    public Game(player p1, player p2, Board ad)
    {
    	player1= p1;
    	player2= p2;
    	arrayedit= ad;
    }
    
    // These methods are getters.
    public player getPlayer1() { return player1;}
	public player getPlayer2() { return player2;}
	public Board getBoard() { return arrayedit;}
	
	
	//These methods are setters.
	public void setplayer1(player p1) { player1 = p1;}
	public void setplayer2(player p2) { player2 = p2;}
	public void setBoard(Board ad) { arrayedit = ad;}
	
	
	// This method is used to name the players .
	public void takeNames_players(Scanner input)
	{
		player1.giveName( input, "1st");
		player2.giveName( input, "2nd");
	}
	
	// This method uses the class players to give chips to the players. 
	public void giveChips(Scanner input)
	{
		player1.select_chip(input, player2);
	}
	
	//This method selects random the first player.
	public int random_selection_player()
	{
		Random selection = new Random();
	    return selection.nextInt(2) + 1;
	}
	
   // This method  implements the process of game.
	public boolean game_process(player p, Scanner input)
    {
		boolean finish;
    	int choice_player;  // The parameter choice_player is the column that  the player has selected.
    	
    	choice_player = p.select_column_player(input, arrayedit.getColumns(), arrayedit.getRow());  
	    arrayedit.push_ChipPlayer(arrayedit.getRowi(choice_player - 1), arrayedit.getArrayChips_Players(), p);  // push the chip of player in the arraychip_player.
	    arrayedit.printArrayChip_Players();
	    finish =  p.checkWinnerPlayer(arrayedit.getRowi(choice_player - 1), arrayedit); // check if the game has a winner.
	    arrayedit.setRowi(choice_player - 1); // decrease the row in the position choice_player by 1.
	    
	    return finish;
	 }
	
	// This method prints the results of the game.
	public void gameresults(int who_select, int sum_repeat)
	{
		System.out.println("");
		if(who_select==2 && sum_repeat< arrayedit.getRows()*arrayedit.getColumns())
		  {
			  System.out.println("GAME OVER. THE WINNER IS " + player1.getName() + ".");
		  }
		  else if (who_select==1 && sum_repeat< arrayedit.getRows()*arrayedit.getColumns())
		  {
			  System.out.println("GAME OVER. THE WINNER IS " + player2.getName() + ".");
		  }
		  else
		  {
			  System.out.println("GAME OVER. WE HAVE A DRAW");
		  }
	}	
}
