/**
 * Created by djanzen on 1/21/16.
 */
public class Card implements Comparable<Card>{
    private Suit suit;
    private Rank rank;

    public Card(Suit suit, Rank rank){
        this.suit = suit;
        this.rank = rank;
    }

    public Suit getSuit(){
        return suit;
    }

    public Rank getRank(){
        return rank;
    }

    public int compareTo(Card other){
        if ( getRank().getValue() < other.getRank().getValue() ) return -1;
        else if ( getRank().getValue() ==  other.getRank().getValue()) return 0;
        else return 1;
    }
}
