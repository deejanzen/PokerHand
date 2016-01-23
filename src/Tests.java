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
        Card C3 = new Card(Suit.Clubs, Rank.Three);
        Card C4 = new Card(Suit.Clubs, Rank.Four);
        Card C5 = new Card(Suit.Clubs, Rank.Five);
        Card C6 = new Card(Suit.Clubs, Rank.Six);
        Card C7 = new Card(Suit.Clubs, Rank.Seven);
        Card C8 = new Card(Suit.Clubs, Rank.Eight);
        Card C9 = new Card(Suit.Clubs, Rank.Nine);
        Card C10 = new Card(Suit.Clubs, Rank.Ten);
        Card CJ = new Card(Suit.Clubs, Rank.Jack);
        Card CQ = new Card(Suit.Clubs, Rank.Queen);
        Card CK = new Card(Suit.Clubs, Rank.King);
        Card CA = new Card(Suit.Clubs, Rank.Ace);

        Card D2 = new Card(Suit.Diamonds, Rank.Deuce);
        Card D3 = new Card(Suit.Diamonds, Rank.Three);
        Card D4 = new Card(Suit.Diamonds, Rank.Four);
        Card D5 = new Card(Suit.Diamonds, Rank.Five);
        Card D6 = new Card(Suit.Diamonds, Rank.Six);
        Card D7 = new Card(Suit.Diamonds, Rank.Seven);
        Card D8 = new Card(Suit.Diamonds, Rank.Eight);
        Card D9 = new Card(Suit.Diamonds, Rank.Nine);
        Card D10 = new Card(Suit.Diamonds, Rank.Ten);
        Card DJ = new Card(Suit.Diamonds, Rank.Jack);
        Card DQ = new Card(Suit.Diamonds, Rank.Queen);
        Card DK = new Card(Suit.Diamonds, Rank.King);
        Card DA = new Card(Suit.Diamonds, Rank.Ace);

        Card S2 = new Card(Suit.Spades, Rank.Deuce);
        Card H2 = new Card(Suit.Hearts, Rank.Deuce);
        Card HA = new Card(Suit.Hearts, Rank.Ace);

        Card S7 = new Card(Suit.Spades, Rank.Seven);
        Card SJ = new Card(Suit.Spades, Rank.Jack);


        PokerHand pairDeucesA73 = new PokerHand(DA,C2,D2,C3,S7);

        PokerHand pairAce = new PokerHand(CK,CQ,DA,CJ,SJ);
        assertEquals(HandRank.OnePair, pairDeucesA73.getHandRank());
        assertEquals(HandRank.OnePair, pairAce.getHandRank());
        assertEquals(1, pairAce.compareTo(pairDeucesA73));
        assertEquals(-1, pairDeucesA73.compareTo(pairAce));

        PokerHand pairDeuces432 = new PokerHand(CQ,H2,CK,C3,S2);
        assertEquals(1, pairDeucesA73.compareTo(pairDeuces432));
        assertEquals(0, pairDeucesA73.compareTo(pairDeucesA73));

        PokerHand pairDeuces01 = new PokerHand(S2,H2,C6,C8,C9);
        PokerHand pairDeuces02 = new PokerHand(S2,H2,C7,C8,C9);
        assertEquals(-1, pairDeuces01.compareTo(pairDeuces02));

        PokerHand threeDeuces01 = new PokerHand(S2,H2,D2,C8,C9);
        assertEquals(HandRank.HighCard ,threeDeuces01.getHandRank());

        PokerHand pair05 = new PokerHand(C2,C3,C4,C5,D5);
        assertEquals(HandRank.OnePair, pair05.getHandRank());
        PokerHand pair06 = new PokerHand(C2,C3,D3,C4,C5);
        assertEquals(HandRank.OnePair, pair06.getHandRank());
        PokerHand pair07 = new PokerHand(C2,C3,C4,D4,C5);
        assertEquals(HandRank.OnePair, pair07.getHandRank());

        PokerHand pair08 = new PokerHand(D3,D4,D10,CJ,DJ);
        PokerHand pair09 = new PokerHand(D2,D4,D10,CJ,DJ);
        assertEquals(1, pair08.compareTo(pair09));

    }
}//end Tests
