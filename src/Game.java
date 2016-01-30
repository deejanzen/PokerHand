import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by djanzen on 1/30/16.
 */
public class Game {
    public static void main(String [] args){
        Scanner input = new Scanner(System.in);
        System.out.print("How many players? ");
        int numberPlayers = input.nextInt();


        Dealer deals = new Dealer();
        ArrayList<Player> players = new ArrayList<>();
        for (int i = 0; i < numberPlayers; i++) {
            players.add(new Player());

        }
        //game
        while(true) {

            for (int i = 0; i < numberPlayers;i++) {
                deals.getPot(players.get(i).getAnte());
            }
            System.out.println("\n");
            System.out.println("Community Cards: ");




            System.out.print("Play another round? y or n? ");
            String anotherGame = input.next();
            if ( anotherGame.equals("n") ) break;
        }


    }
}
