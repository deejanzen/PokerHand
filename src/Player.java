import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by djanzen on 1/30/16.
 */
public class Player {
    private List<Card> playerCards;
    private double money;
    private PokerHand bestHand;

    public Player(){
        money = 100.00;
        playerCards = new ArrayList<>();
    }

    public double getAnte(){
        return money-=2.00;
    }

    public void addToPlayerCards(Card c){
        playerCards.add(c);
    }

    public List<Card> getPlayerCards(){
        return playerCards;
    }

    public double getMoney(){
        return money;
    }

    public void clearPlayerCards(){
        playerCards.clear();
    }

    public void sortPlayerCards(){
        Collections.sort(playerCards);
    }

}
