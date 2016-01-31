/**
 * Created by djanzen on 1/22/16.
 */
public enum HandRank {
    HighCard(0), OnePair(1), TwoPair(2), ThreeOfAKind(3), Straight(4), Flush(5), FullHouse(6),
    FourOfAKind(7), StraightFlush(8), RoyalFLush(9);

    private int number;
    HandRank(int i) { number = i; }
    public int getValue(){
        return number;
    }
    public String toString(){
        String result = new String("");
        switch(getValue()){
            case 0: result = "High Card"; break;
            case 1: result = "Pair"; break;
            case 2: result = "Two Pair"; break;
            case 3: result = "Three of a kind"; break;
            case 4: result = "Straight"; break;
            case 5: result = "Flush"; break;
            case 6: result = "Full House"; break;
            case 7: result = "Four of a kind"; break;
            case 8: result = "Straight Flush"; break;
            case 9: result = "Royal Straight"; break;

        }
        return result;
    }
}
