/**
 * Created by djanzen on 1/21/16.
 */
import org.junit.*;
import static org.junit.Assert.*;

public class Tests {
    @Test
    public void getValue(){

        assertEquals(Rank.Duece.getValue(), 2);
        assertEquals(Rank.Three.getValue(), 3);
        assertEquals(Rank.Four.getValue(), 4);
        assertEquals(Rank.Five.getValue(), 5);
        assertEquals(Rank.Six.getValue(), 6);
        assertEquals(Rank.Seven.getValue(), 7);
        assertEquals(Rank.Eight.getValue(), 8);
        assertEquals(Rank.Nine.getValue(), 9);
        assertEquals(Rank.Ten.getValue(), 10);
        assertEquals(Rank.Jack.getValue(), 11);
        assertEquals(Rank.Queen.getValue(), 12);
        assertEquals(Rank.King.getValue(), 13);
        assertEquals(Rank.Ace.getValue(), 14);
    }
    @Test
    public void PokerHandTest(){

    }
    @Test(expected = DuplicateCardException.class)
    public void tryToAddTheSameCardTwice() {
        Card C2 = new Card(Suit.Clubs,Rank.Duece);
        Card C3 = new Card(Suit.Clubs,Rank.Duece);
        Card C4 = new Card(Suit.Clubs,Rank.Duece);
        Card C5 = new Card(Suit.Clubs,Rank.Duece);
        new PokerHand(C2, C3, C4, C4, C5);  // Assume C2 = new Card(Rank.Deuce, Suit.Clubs), C3 = ...
    }
}//end Tests
