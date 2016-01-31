import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by djanzen on 1/30/16.
 */
public class Dealer {
    private List<Card> deck;
    private double pot;
    private int marker;

    public Dealer(){
        pot = 0;
        marker = 0;
        deck = new ArrayList<>();


        deck.add( new Card(Rank.Deuce, Suit.Clubs) );
        deck.add( new Card(Rank.Three, Suit.Clubs) );
        deck.add( new Card(Rank.Four, Suit.Clubs) );
        deck.add( new Card(Rank.Five, Suit.Clubs) );
        deck.add( new Card(Rank.Six, Suit.Clubs) );
        deck.add( new Card(Rank.Seven, Suit.Clubs) );
        deck.add( new Card(Rank.Eight, Suit.Clubs) );
        deck.add( new Card(Rank.Nine, Suit.Clubs) );
        deck.add( new Card(Rank.Ten, Suit.Clubs) );
        deck.add( new Card(Rank.Jack, Suit.Clubs) );
        deck.add( new Card(Rank.Queen,Suit.Clubs) );
        deck.add( new Card(Rank.King, Suit.Clubs) );
        deck.add( new Card(Rank.Ace, Suit.Clubs) );

        deck.add( new Card(Rank.Deuce, Suit.Diamonds) );
        deck.add( new Card(Rank.Three, Suit.Diamonds) );
        deck.add( new Card(Rank.Four, Suit.Diamonds) );
        deck.add( new Card(Rank.Five, Suit.Diamonds) );
        deck.add( new Card(Rank.Six, Suit.Diamonds) );
        deck.add( new Card(Rank.Seven, Suit.Diamonds) );
        deck.add( new Card(Rank.Eight, Suit.Diamonds) );
        deck.add( new Card(Rank.Nine, Suit.Diamonds) );
        deck.add( new Card(Rank.Ten, Suit.Diamonds) );
        deck.add( new Card(Rank.Jack, Suit.Diamonds) );
        deck.add( new Card(Rank.Queen,Suit.Diamonds) );
        deck.add( new Card(Rank.King, Suit.Diamonds) );
        deck.add( new Card(Rank.Ace, Suit.Diamonds) );

        deck.add( new Card(Rank.Deuce, Suit.Hearts) );
        deck.add( new Card(Rank.Three, Suit.Hearts) );
        deck.add( new Card(Rank.Four, Suit.Hearts) );
        deck.add( new Card(Rank.Five, Suit.Hearts) );
        deck.add( new Card(Rank.Six, Suit.Hearts) );
        deck.add( new Card(Rank.Seven, Suit.Hearts) );
        deck.add( new Card(Rank.Eight, Suit.Hearts) );
        deck.add( new Card(Rank.Nine, Suit.Hearts) );
        deck.add( new Card(Rank.Ten, Suit.Hearts) );
        deck.add( new Card(Rank.Jack, Suit.Hearts) );
        deck.add( new Card(Rank.Queen,Suit.Hearts) );
        deck.add( new Card(Rank.King, Suit.Hearts) );
        deck.add( new Card(Rank.Ace, Suit.Hearts) );

        deck.add( new Card(Rank.Deuce, Suit.Spades) );
        deck.add( new Card(Rank.Three, Suit.Spades) );
        deck.add( new Card(Rank.Four, Suit.Spades) );
        deck.add( new Card(Rank.Five, Suit.Spades) );
        deck.add( new Card(Rank.Six, Suit.Spades) );
        deck.add( new Card(Rank.Seven, Suit.Spades) );
        deck.add( new Card(Rank.Eight, Suit.Spades) );
        deck.add( new Card(Rank.Nine, Suit.Spades) );
        deck.add( new Card(Rank.Ten, Suit.Spades) );
        deck.add( new Card(Rank.Jack, Suit.Spades) );
        deck.add( new Card(Rank.Queen,Suit.Spades) );
        deck.add( new Card(Rank.King, Suit.Spades) );
        deck.add( new Card(Rank.Ace, Suit.Spades) );


        Collections.shuffle(deck);
    }

    public void getPot(double ante){
        pot += ante;
    }

    public void shuffle(){
        marker = 0;
        Collections.shuffle(deck);
    }
    public Card deal(){
        return deck.get(marker++);
    }

    public List<Card> getCommonHand(){
        List<Card> commonHand = new ArrayList<>();
        for (int i = 0; i < 5;i++){
            commonHand.add(deal());
        }
        Collections.sort(commonHand);
        return commonHand;
    }

}
