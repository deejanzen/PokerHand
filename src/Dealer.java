import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by djanzen on 1/30/16.
 */
public class Dealer {
    private List<Card> deck;
    private double pot;

    public Dealer(){
        pot = 0;

        deck = new ArrayList<>();
        deck.add( new Card(Suit.Clubs, Rank.Deuce) );
        deck.add( new Card(Suit.Clubs, Rank.Three) );
        deck.add( new Card(Suit.Clubs, Rank.Four) );
        deck.add( new Card(Suit.Clubs, Rank.Five) );
        deck.add( new Card(Suit.Clubs, Rank.Six) );
        deck.add( new Card(Suit.Clubs, Rank.Seven) );
        deck.add( new Card(Suit.Clubs, Rank.Eight) );
        deck.add( new Card(Suit.Clubs, Rank.Nine) );
        deck.add( new Card(Suit.Clubs, Rank.Ten) );
        deck.add( new Card(Suit.Clubs, Rank.Jack) );
        deck.add( new Card(Suit.Clubs, Rank.Queen) );
        deck.add( new Card(Suit.Clubs, Rank.King) );
        deck.add( new Card(Suit.Clubs, Rank.Ace) );

        deck.add( new Card(Suit.Diamonds, Rank.Deuce) );
        deck.add( new Card(Suit.Diamonds, Rank.Three) );
        deck.add( new Card(Suit.Diamonds, Rank.Four) );
        deck.add( new Card(Suit.Diamonds, Rank.Five) );
        deck.add( new Card(Suit.Diamonds, Rank.Six) );
        deck.add( new Card(Suit.Diamonds, Rank.Seven) );
        deck.add( new Card(Suit.Diamonds, Rank.Eight) );
        deck.add( new Card(Suit.Diamonds, Rank.Nine) );
        deck.add( new Card(Suit.Diamonds, Rank.Ten) );
        deck.add( new Card(Suit.Diamonds, Rank.Jack) );
        deck.add( new Card(Suit.Diamonds, Rank.Queen) );
        deck.add( new Card(Suit.Diamonds, Rank.King) );
        deck.add( new Card(Suit.Diamonds, Rank.Ace) );

        deck.add( new Card(Suit.Hearts, Rank.Deuce) );
        deck.add( new Card(Suit.Hearts, Rank.Three) );
        deck.add( new Card(Suit.Hearts, Rank.Four) );
        deck.add( new Card(Suit.Hearts, Rank.Five) );
        deck.add( new Card(Suit.Hearts, Rank.Six) );
        deck.add( new Card(Suit.Hearts, Rank.Seven) );
        deck.add( new Card(Suit.Hearts, Rank.Eight) );
        deck.add( new Card(Suit.Hearts, Rank.Nine) );
        deck.add( new Card(Suit.Hearts, Rank.Ten) );
        deck.add( new Card(Suit.Hearts, Rank.Jack) );
        deck.add( new Card(Suit.Hearts, Rank.Queen) );
        deck.add( new Card(Suit.Hearts, Rank.King) );
        deck.add( new Card(Suit.Hearts, Rank.Ace) );

        deck.add( new Card(Suit.Spades, Rank.Deuce) );
        deck.add( new Card(Suit.Spades, Rank.Three) );
        deck.add( new Card(Suit.Spades, Rank.Four) );
        deck.add( new Card(Suit.Spades, Rank.Five) );
        deck.add( new Card(Suit.Spades, Rank.Six) );
        deck.add( new Card(Suit.Spades, Rank.Seven) );
        deck.add( new Card(Suit.Spades, Rank.Eight) );
        deck.add( new Card(Suit.Spades, Rank.Nine) );
        deck.add( new Card(Suit.Spades, Rank.Ten) );
        deck.add( new Card(Suit.Spades, Rank.Jack) );
        deck.add( new Card(Suit.Spades, Rank.Queen) );
        deck.add( new Card(Suit.Spades, Rank.King) );
        deck.add( new Card(Suit.Spades, Rank.Ace) );
    }

    public void getPot(double ante){
        pot += ante;
    }
    public void shuffle(){
        Collections.shuffle(deck);
    }
    public Card deal(){
        return deck.remove(0);
    }

}
