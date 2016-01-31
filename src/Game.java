import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * Created by djanzen on 1/30/16.
 */
public class Game {
    public static void main(String [] args){
        List<Card> common;

        Scanner input = new Scanner(System.in);
        System.out.print("How many players? ");
        int numberPlayers = input.nextInt();


        Dealer dealer = new Dealer();
        ArrayList<Player> playersList = new ArrayList<>();
        for (int i = 0; i < numberPlayers; i++) {
            playersList.add(new Player());

        }
        //game
        while(true) {
            //get ante
            for (int i = 0; i < numberPlayers;i++) {
                dealer.getPot(playersList.get(i).getAnte());
            }
            System.out.println("\n");

            //deal two cards to each player
            for (int i = 0; i < numberPlayers;i++) {
                for (int j = 0; j<2; j++){
                    playersList.get(i).addToPlayerCards(dealer.deal());
                }
                playersList.get(i).sortPlayerCards();
            }
            //display common cards
            common = dealer.getCommonHand();
            //determine players best
            for (int i = 0; i < numberPlayers;i++){
                playersList.get(i).setBestHand(dealer.determineBestHand(playersList.get(i).getPlayerCards(), common ));
            }
            //display common cards
            System.out.print("Community Cards: ");
            for( Card c: common){
                System.out.print(c.toString() + " ");
            }
            System.out.println("\n++++++++++++++++++++++++++++++++++++");
            //show players
            for (int i = 0; i < numberPlayers;i++) {
                System.out.print("Player " + (i+1) + ": $" + playersList.get(i).getMoney() + " - " );
                for (Card c: playersList.get(i).getPlayerCards()){
                    System.out.print(c.toString() + " ");
                }
                System.out.println("\n");
                System.out.print("\tBest Hand: " + playersList.get(i).getBestHand().toString() + " - " + playersList.get(i).getBestHand().getHandRank().toString());
                System.out.println("\n");
            }



            System.out.print("Play another round? y or n? ");
            String anotherGame = input.next();
            if ( anotherGame.equals("n") ) break;
            dealer.shuffle();
            common.clear();
            for (int i = 0; i < numberPlayers;i++){
                playersList.get(i).clearPlayerCards();
            }
        }


    }
}
