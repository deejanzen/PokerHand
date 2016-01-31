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

    public String toString(){
        String rank = "";
        switch ( getRank() ) {
            case Deuce: rank = "2"; break;
            case Three: rank = "3"; break;
            case Four: rank = "4"; break;
            case Five: rank = "5"; break;
            case Six: rank = "6"; break;
            case Seven: rank = "7"; break;
            case Eight: rank = "8"; break;
            case Nine: rank = "9"; break;
            case Ten: rank = "10"; break;
            case Jack: rank = "J"; break;
            case Queen: rank = "Q"; break;
            case King: rank = "K"; break;
            case Ace: rank = "A"; break;
        }

        char suit = ' ';
        switch ( getSuit() ) {
            case Clubs: suit = '\u2663'; break;
            case Diamonds: suit = '\u2666'; break;
            case Hearts: suit = '\u2665'; break;
            case Spades: suit = '\u2660'; break;
        }

        return rank + suit;
    }
}
