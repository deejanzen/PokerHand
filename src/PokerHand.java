import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * Created by djanzen on 1/21/16.
 */
public class PokerHand {
    private List<Card> hand;
    private HandRank handRank;
    private List<Card> kicker;

    public PokerHand(Card a, Card b, Card c, Card d, Card e){
        hand = new ArrayList<>();
        kicker = new ArrayList<>();
        Stack<Card> temp = new Stack<>();
        temp.push(a);
        temp.push(b);
        temp.push(c);
        temp.push(d);
        temp.push(e);

        while ( !temp.empty() ){
            if ( !hand.contains( temp.peek() ) )  hand.add( temp.pop() );
            else throw new DuplicateCardException();
        }

        Collections.sort(hand);

        //if you have a pair then check the pair based hands
        if ( hand.get(0).getRank().getValue() == hand.get(1).getRank().getValue() ||
             hand.get(1).getRank().getValue() == hand.get(2).getRank().getValue() ||
             hand.get(2).getRank().getValue() == hand.get(3).getRank().getValue() ||
             hand.get(3).getRank().getValue() == hand.get(4).getRank().getValue()     ){

            //pp*** where */=*
            if (hand.get(0).getRank().getValue() == hand.get(1).getRank().getValue() &&
                hand.get(2).getRank().getValue() != hand.get(3).getRank().getValue() &&
                hand.get(3).getRank().getValue() != hand.get(4).getRank().getValue()    ){

                    handRank = HandRank.OnePair;
                    kicker.add(2, hand.get(2));
                    kicker.add(3, hand.get(3));
                    kicker.add(4, hand.get(4));
            }
        }

        //otherwise...
        else {
            return;
        }



    }//end constructor

    public HandRank getHandRank(){
        return handRank;
    }
    public List<Card> getKicker(){
        return kicker;
    }



}//end PokerHand
