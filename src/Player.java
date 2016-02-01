import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class Player {
    private List<Card> playerCards;
    private double money;
    private PokerHand bestHand;

    public Player(){
        money = 100.00;
        playerCards = new ArrayList<>();
        bestHand = null;
    }

    public double getAnte(){
        money -=2.00;
        return 2.00;
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

    public void setMoney(double winnings){
        money += winnings;
    }

    public void clearPlayerCards(){
        playerCards.clear();
    }

    public void sortPlayerCards(){
        Collections.sort(playerCards);
    }
    public void setBestHand(PokerHand newHand){
        bestHand = newHand;
    }
    public PokerHand getBestHand(){
        return bestHand;
    }

}
