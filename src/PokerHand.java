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
        handRank = setHandRankAndKicker(hand, kicker);

    }//end constructor

    public HandRank getHandRank(){
        return handRank;
    }
    public List<Card> getKicker(){
        return kicker;
    }

    public int compareTo(PokerHand other){
        if ( handRank.getValue() < other.getHandRank().getValue() ) return -1;
        else if ( handRank.getValue() > other.getHandRank().getValue() ) return 1;
        else {
            int count = 0;
            for (Card c: kicker) {
                if (c.getRank().getValue() < other.getKicker().get(count).getRank().getValue())
                    return -1;
                else if (c.getRank().getValue() > other.getKicker().get(count).getRank().getValue())
                    return 1;
                count += 1;
            }

        }
        return 0;

    }//compareTo

    private static HandRank setHandRankAndKicker(List<Card> hand, List<Card> kicker){
        //if you have a pair then check the pair based hands
        if ( hand.get(0).getRank().getValue() == hand.get(1).getRank().getValue() ||
        hand.get(1).getRank().getValue() == hand.get(2).getRank().getValue() ||
        hand.get(2).getRank().getValue() == hand.get(3).getRank().getValue() ||
        hand.get(3).getRank().getValue() == hand.get(4).getRank().getValue()     ){

            //pp*** where */=*
            if (hand.get(0).getRank().getValue() == hand.get(1).getRank().getValue() &&
            hand.get(2).getRank().getValue() != hand.get(3).getRank().getValue() &&
            hand.get(3).getRank().getValue() != hand.get(4).getRank().getValue()     ){

                kicker.add(0, hand.get(0)); //pair rank
                kicker.add(1, hand.get(4)); //1st k
                kicker.add(2, hand.get(3));
                kicker.add(3, hand.get(2));
                return HandRank.OnePair;
            }
        }

        //otherwise...flush, straight etc
        else {
            return HandRank.HighCard;
        }
        return HandRank.HighCard;

    }




}//end PokerHand
