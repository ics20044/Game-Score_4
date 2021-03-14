import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		System.out.println("This is Score4");
		Scanner input = new Scanner(System.in);
		Game Score4game = new Game(); // Create the object Score4game.
		Score4game.takeNames_players(input);
		Score4game.giveChips(input);
		Score4game.getBoard().giveRowsColumns(input);
        Score4game.getBoard().completeArrayChips_Players();   // Complete arraychips_players with '-'.
        Score4game.getBoard().printArrayChip_Players();
        Score4game.getBoard().completeRow();     // Complete row with rows - 1.
        System.out.println();   
        int  who_select = Score4game.random_selection_player();
        boolean finishgame = false;
        int sum_repeat=0;
        while(!finishgame && sum_repeat < Score4game.getBoard().getRows() * Score4game.getBoard().getColumns()) // Repeat the while loop when the game is not  finished yet and sum_repeat is less than sum of element of the array. 
        {
         if(who_select == 1 )
         {
            finishgame = Score4game.game_process(Score4game.getPlayer1(), input);
	        who_select = 2;
         }
         else
         {
            finishgame = Score4game.game_process(Score4game.getPlayer2(), input);
            who_select = 1;
         }
         
	     if(finishgame==false)
	     {
            sum_repeat++;
	     }
	    }
      
        Score4game.gameresults(who_select, sum_repeat);
    }
}
