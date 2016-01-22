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
}
