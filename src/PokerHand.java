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
    }//end getHandRank

    public List<Card> getKicker(){
        return kicker;
    }//end getKicker

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
    }//end compareTo

    private static HandRank setHandRankAndKicker(List<Card> hand, List<Card> kicker){
        //if you have a pair then check the pair based hands
        if (  hasPair(hand)  ){

            //pp*** where */=*
            if (hand.get(0).getRank().getValue() == hand.get(1).getRank().getValue() &&
                hand.get(1).getRank().getValue() != hand.get(2).getRank().getValue() &&
                hand.get(2).getRank().getValue() != hand.get(3).getRank().getValue() &&
                hand.get(3).getRank().getValue() != hand.get(4).getRank().getValue()   ) {

                    kicker.add(0, hand.get(0)); //pair rank
                    kicker.add(1, hand.get(4)); //1st k
                    kicker.add(2, hand.get(3));
                    kicker.add(3, hand.get(2));
                    return HandRank.OnePair;
                }

            //*pp**
            if (hand.get(0).getRank().getValue() != hand.get(1).getRank().getValue() &&
                hand.get(1).getRank().getValue() == hand.get(2).getRank().getValue() &&
                hand.get(2).getRank().getValue() != hand.get(3).getRank().getValue() &&
                hand.get(3).getRank().getValue() != hand.get(4).getRank().getValue()    ) {

                    kicker.add(0, hand.get(1)); //pair rank
                    kicker.add(1, hand.get(4)); //1st k
                    kicker.add(2, hand.get(3));
                    kicker.add(3, hand.get(0));
                    return HandRank.OnePair;
                }

            //**pp* where */=*
            if (hand.get(0).getRank().getValue() != hand.get(1).getRank().getValue() &&
                hand.get(1).getRank().getValue() != hand.get(2).getRank().getValue() &&
                hand.get(2).getRank().getValue() == hand.get(3).getRank().getValue() &&
                hand.get(3).getRank().getValue() != hand.get(4).getRank().getValue()    ) {

                    kicker.add(0, hand.get(2)); //pair rank
                    kicker.add(1, hand.get(4)); //1st k
                    kicker.add(2, hand.get(1));
                    kicker.add(3, hand.get(0));
                    return HandRank.OnePair;
            }

            //***pp where */=*
            if (hand.get(0).getRank().getValue() != hand.get(1).getRank().getValue() &&
                hand.get(1).getRank().getValue() != hand.get(2).getRank().getValue() &&
                hand.get(2).getRank().getValue() != hand.get(3).getRank().getValue() &&
                hand.get(3).getRank().getValue() == hand.get(4).getRank().getValue()) {

                    kicker.add(0, hand.get(3)); //pair rank
                    kicker.add(1, hand.get(2)); //1st k
                    kicker.add(2, hand.get(1));
                    kicker.add(3, hand.get(0));
                    return HandRank.OnePair;
            }

            //TwoPair
            //PPbb*
            if (hand.get(0).getRank().getValue() == hand.get(1).getRank().getValue() &&
                hand.get(1).getRank().getValue() != hand.get(2).getRank().getValue() &&
                hand.get(2).getRank().getValue() == hand.get(3).getRank().getValue() &&
                hand.get(3).getRank().getValue() != hand.get(4).getRank().getValue()) {

                    if( hand.get(0).getRank().getValue() > hand.get(2).getRank().getValue()){
                        kicker.add(0, hand.get(0));
                        kicker.add(1, hand.get(2));
                        kicker.add(2, hand.get(4));
                        return HandRank.TwoPair;

                    }
                    else{
                        kicker.add(0, hand.get(2));
                        kicker.add(1, hand.get(0));
                        kicker.add(2, hand.get(4));
                        return HandRank.TwoPair;

                    }
            }

            //PP*bb
            if (hand.get(0).getRank().getValue() == hand.get(1).getRank().getValue() &&
                hand.get(1).getRank().getValue() != hand.get(2).getRank().getValue() &&
                hand.get(2).getRank().getValue() != hand.get(3).getRank().getValue() &&
                hand.get(3).getRank().getValue() == hand.get(4).getRank().getValue()) {

                    if( hand.get(0).getRank().getValue() > hand.get(3).getRank().getValue()){
                        kicker.add(0, hand.get(0));
                        kicker.add(1, hand.get(3));
                        kicker.add(2, hand.get(2));
                        return HandRank.TwoPair;

                    }
                    else{
                        kicker.add(0, hand.get(3));
                        kicker.add(1, hand.get(0));
                        kicker.add(2, hand.get(2));
                        return HandRank.TwoPair;

                }
            }

            //*PPbb
            if (hand.get(0).getRank().getValue() != hand.get(1).getRank().getValue() &&
                hand.get(1).getRank().getValue() == hand.get(2).getRank().getValue() &&
                hand.get(2).getRank().getValue() != hand.get(3).getRank().getValue() &&
                hand.get(3).getRank().getValue() == hand.get(4).getRank().getValue()) {

                    if( hand.get(1).getRank().getValue() > hand.get(3).getRank().getValue()){
                        kicker.add(0, hand.get(1));
                        kicker.add(1, hand.get(3));
                        kicker.add(2, hand.get(0));
                        return HandRank.TwoPair;

                    }
                    else{
                        kicker.add(0, hand.get(3));
                        kicker.add(1, hand.get(1));
                        kicker.add(2, hand.get(0));
                        return HandRank.TwoPair;
                    }
            }

            //threeKind
            //PPP**
            if (hand.get(0).getRank().getValue() == hand.get(1).getRank().getValue() &&
                hand.get(1).getRank().getValue() == hand.get(2).getRank().getValue() &&
                hand.get(2).getRank().getValue() != hand.get(3).getRank().getValue() &&
                hand.get(3).getRank().getValue() != hand.get(4).getRank().getValue()) {

                        kicker.add(0, hand.get(0));
                        kicker.add(1, hand.get(3));
                        kicker.add(2, hand.get(4));
                        return HandRank.ThreeOfAKind;
            }
            //*PPP*
            if (hand.get(0).getRank().getValue() != hand.get(1).getRank().getValue() &&
                hand.get(1).getRank().getValue() == hand.get(2).getRank().getValue() &&
                hand.get(2).getRank().getValue() == hand.get(3).getRank().getValue() &&
                hand.get(3).getRank().getValue() != hand.get(4).getRank().getValue()) {

                    kicker.add(0, hand.get(1));
                    kicker.add(1, hand.get(4));
                    kicker.add(2, hand.get(0));
                    return HandRank.ThreeOfAKind;
            }
            //**PPP
            if (hand.get(0).getRank().getValue() != hand.get(1).getRank().getValue() &&
                hand.get(1).getRank().getValue() != hand.get(2).getRank().getValue() &&
                hand.get(2).getRank().getValue() == hand.get(3).getRank().getValue() &&
                hand.get(3).getRank().getValue() == hand.get(4).getRank().getValue()) {

                    kicker.add(0, hand.get(2));
                    kicker.add(1, hand.get(1));
                    kicker.add(2, hand.get(0));
                    return HandRank.ThreeOfAKind;


            }
            //full house
            //PPPbb
            if (hand.get(0).getRank().getValue() == hand.get(1).getRank().getValue() &&
                hand.get(1).getRank().getValue() == hand.get(2).getRank().getValue() &&
                hand.get(2).getRank().getValue() != hand.get(3).getRank().getValue() &&
                hand.get(3).getRank().getValue() == hand.get(4).getRank().getValue()) {

                    kicker.add(0, hand.get(0));
                    return HandRank.FullHouse;
            }
            //bbPPP
            if (hand.get(0).getRank().getValue() == hand.get(1).getRank().getValue() &&
                hand.get(1).getRank().getValue() != hand.get(2).getRank().getValue() &&
                hand.get(2).getRank().getValue() == hand.get(3).getRank().getValue() &&
                hand.get(3).getRank().getValue() == hand.get(4).getRank().getValue()) {

                    kicker.add(0, hand.get(2));
                    return HandRank.FullHouse;
            }

            //four of a kind
            //PPPPb
            if (hand.get(0).getRank().getValue() == hand.get(1).getRank().getValue() &&
                hand.get(1).getRank().getValue() == hand.get(2).getRank().getValue() &&
                hand.get(2).getRank().getValue() == hand.get(3).getRank().getValue() &&
                hand.get(3).getRank().getValue() != hand.get(4).getRank().getValue()) {

                    kicker.add(0, hand.get(0));
                    return HandRank.FourOfAKind;
            }
            //bPPPP
            if (hand.get(0).getRank().getValue() != hand.get(1).getRank().getValue() &&
                hand.get(1).getRank().getValue() == hand.get(2).getRank().getValue() &&
                hand.get(2).getRank().getValue() == hand.get(3).getRank().getValue() &&
                hand.get(3).getRank().getValue() == hand.get(4).getRank().getValue()) {

                    kicker.add(0, hand.get(1));
                    return HandRank.FourOfAKind;
            }
        }//hasPair

        //otherwise...straight, straightFlush royalStraightFlush etc
        else if ( hasStraight(hand) ){
            if ( hasFlush(hand) ){
                //check ace draw or royal flush
                if (hand.get(4).getRank().getValue() == 14) {
                    if(hand.get(3).getRank().getValue() == 5){
                        kicker.add(0, hand.get(3));
                        return HandRank.StraightFlush;
                    }
                    else {
                        //kicker.add(0, hand.get(4));
                        return HandRank.RoyalFLush;
                    }
                }

                kicker.add(0, hand.get(4));
                return HandRank.StraightFlush;
            }//hasFlush

            if (hand.get(3).getRank().getValue() == 5 &&
                hand.get(4).getRank().getValue() == 14   ){
                kicker.add(0, hand.get(3));
            }
            else
                kicker.add(0, hand.get(4));

            return HandRank.Straight;
        }//hasStraight

        //otherwise only flush
        else if (hasFlush(hand)) {
            kicker.add(0, hand.get(4));
            return HandRank.Flush;
        }

        //not a pair nor straight or flush
        for (int i = 4; i > -1;i--) {
            kicker.add(hand.get(i));
        }
        return HandRank.HighCard;

    }//end setHandRankAndKicker

    private static boolean hasPair(List<Card> hand){
        if (hand.get(0).getRank().getValue() == hand.get(1).getRank().getValue() ||
            hand.get(1).getRank().getValue() == hand.get(2).getRank().getValue() ||
            hand.get(2).getRank().getValue() == hand.get(3).getRank().getValue() ||
            hand.get(3).getRank().getValue() == hand.get(4).getRank().getValue()     ){
                return true;
        }
        return false;
    }//end hasPair

    private static boolean hasStraight(List<Card> hand){
        if ( hand.get(3).getRank().getValue() == 5 && hand.get(4).getRank().getValue() == 14 ||
            hand.get(0).getRank().getValue() + 4 == hand.get(4).getRank().getValue() )
            return true;

        return false;
    }

    private static boolean hasFlush(List<Card> hand){
        if (hand.get(0).getSuit() == hand.get(1).getSuit()  &&
            hand.get(1).getSuit() == hand.get(2).getSuit()  &&
            hand.get(2).getSuit() == hand.get(3).getSuit()  &&
            hand.get(3).getSuit() == hand.get(4).getSuit()     )
                return true;
        return false;
    }
}//end PokerHand
