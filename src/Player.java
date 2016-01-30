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
    }

    public double getAnte(){
        return money-=2.00;
    }

}
