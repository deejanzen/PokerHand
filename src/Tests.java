/**
 * Created by djanzen on 1/21/16.
 */
import org.junit.*;
import static org.junit.Assert.*;

public class Tests {
    @Test
    public void getValue(){

        assertEquals(Rank.Deuce.getValue(), 2);
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
        Card C2 = new Card(Suit.Clubs, Rank.Deuce);
        Card HA = new Card(Suit.Hearts, Rank.Ace);
        Card S7 = new Card(Suit.Spades, Rank.Seven);
        Card D2 = new Card(Suit.Diamonds, Rank.Deuce);
        Card C3 = new Card(Suit.Clubs, Rank.Three);
        PokerHand hand01 = new PokerHand(C2, HA, S7, D2, C3);
    }
    @Test(expected = DuplicateCardException.class)
    public void tryToAddTheSameCardTwice() {
        Card C2 = new Card(Suit.Clubs,Rank.Deuce);
        Card C3 = new Card(Suit.Clubs,Rank.Deuce);
        Card C4 = new Card(Suit.Clubs,Rank.Deuce);
        Card C5 = new Card(Suit.Clubs,Rank.Deuce);
        new PokerHand(C2, C3, C4, C4, C5);  // Assume C2 = new Card(Rank.Deuce, Suit.Clubs), C3 = ...
    }
    @Test
    public void showRankValues(){
        String result = "";
        for (Rank r : Rank.values()){
            result = result + r + " ";
        }
        assertEquals("Deuce Three Four Five Six Seven Eight Nine Ten Jack Queen King Ace ", result);
    }
    @Test
    public void showSuitValues(){
        String result = "";
        for (Suit s : Suit.values()){
            result = result + s + " ";
        }
        assertEquals("Clubs Diamonds Hearts Spades ", result);
    }
    @Test
    public void OnePairTests(){
        Card C2 = new Card(Suit.Clubs, Rank.Deuce);
        Card D2 = new Card(Suit.Diamonds, Rank.Deuce);
        Card S2 = new Card(Suit.Spades, Rank.Deuce);
        Card H2 = new Card(Suit.Hearts, Rank.Deuce);
        Card HA = new Card(Suit.Hearts, Rank.Ace);
        Card DA = new Card(Suit.Diamonds, Rank.Ace);
        Card S7 = new Card(Suit.Spades, Rank.Seven);
        Card SJ = new Card(Suit.Spades, Rank.Jack);
        Card C3 = new Card(Suit.Clubs, Rank.Three);
        Card CJ = new Card(Suit.Clubs, Rank.Jack);
        Card CQ = new Card(Suit.Clubs, Rank.Queen);
        Card CK = new Card(Suit.Clubs, Rank.King);

        PokerHand pairTwo = new PokerHand(DA,C2,D2,C3,S7);

        PokerHand pairAce = new PokerHand(CK,CQ,DA,CJ,SJ);
        assertEquals(1, pairTwo.getHandRank().getValue());
        assertEquals(1, pairAce.getHandRank().getValue());
        assertEquals(1, pairAce.compareTo(pairTwo));
        assertEquals(-1, pairTwo.compareTo(pairAce));

        PokerHand pairDeuces432 = new PokerHand(CQ,H2,CK,C3,S2);
        //assertEquals(1, pairTwo.compareTo(pairDeuces432));

    }
}//end Tests
