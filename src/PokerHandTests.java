/**
 * Created by djanzen on 1/21/16.
 */
import org.junit.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;

public class PokerHandTests {
    public Card C2 = new Card(Rank.Deuce, Suit.Clubs);
    public Card C3 = new Card(Rank.Three, Suit.Clubs);
    public Card C4 = new Card(Rank.Four, Suit.Clubs);
    public Card C5 = new Card(Rank.Five, Suit.Clubs);
    public Card C6 = new Card(Rank.Six, Suit.Clubs);
    public Card C7 = new Card(Rank.Seven, Suit.Clubs);
    public Card C8 = new Card(Rank.Eight, Suit.Clubs);
    public Card C9 = new Card(Rank.Nine, Suit.Clubs);
    public Card C10 = new Card(Rank.Ten, Suit.Clubs);
    public Card CJ = new Card(Rank.Jack, Suit.Clubs);
    public Card CQ = new Card(Rank.Queen, Suit.Clubs);
    public Card CK = new Card(Rank.King, Suit.Clubs);
    public Card CA = new Card(Rank.Ace, Suit.Clubs);

    public Card D2 = new Card(Rank.Deuce, Suit.Diamonds);
    public Card D3 = new Card(Rank.Three, Suit.Diamonds);
    public Card D4 = new Card(Rank.Four, Suit.Diamonds);
    public Card D5 = new Card(Rank.Five, Suit.Diamonds);
    public Card D6 = new Card(Rank.Six, Suit.Diamonds);
    public Card D7 = new Card(Rank.Seven, Suit.Diamonds);
    public Card D8 = new Card(Rank.Eight, Suit.Diamonds);
    public Card D9 = new Card(Rank.Nine, Suit.Diamonds);
    public Card D10 = new Card(Rank.Ten, Suit.Diamonds);
    public Card DJ = new Card(Rank.Jack, Suit.Diamonds);
    public Card DQ = new Card(Rank.Queen, Suit.Diamonds);
    public Card DK = new Card(Rank.King, Suit.Diamonds);
    public Card DA = new Card(Rank.Ace, Suit.Diamonds);

    public Card H2 = new Card(Rank.Deuce, Suit.Hearts);
    public Card H3 = new Card(Rank.Three, Suit.Hearts);
    public Card H4 = new Card(Rank.Four, Suit.Hearts);
    public Card H5 = new Card(Rank.Five, Suit.Hearts);
    public Card H6 = new Card(Rank.Six, Suit.Hearts);
    public Card H7 = new Card(Rank.Seven, Suit.Hearts);
    public Card H8 = new Card(Rank.Eight, Suit.Hearts);
    public Card H9 = new Card(Rank.Nine, Suit.Hearts);
    public Card H10 = new Card(Rank.Ten, Suit.Hearts);
    public Card HJ = new Card(Rank.Jack, Suit.Hearts);
    public Card HQ = new Card(Rank.Queen, Suit.Hearts);
    public Card HK = new Card(Rank.King, Suit.Hearts);
    public Card HA = new Card(Rank.Ace, Suit.Hearts);

    public Card S2 = new Card(Rank.Deuce, Suit.Spades);
    public Card S3 = new Card(Rank.Three, Suit.Spades);
    public Card S4 = new Card(Rank.Four, Suit.Spades);
    public Card S5 = new Card(Rank.Five, Suit.Spades);
    public Card S6 = new Card(Rank.Six, Suit.Spades);
    public Card S7 = new Card(Rank.Seven, Suit.Spades);
    public Card S8 = new Card(Rank.Eight, Suit.Spades);
    public Card S9 = new Card(Rank.Nine, Suit.Spades);
    public Card S10 = new Card(Rank.Ten, Suit.Spades);
    public Card SJ = new Card(Rank.Jack, Suit.Spades);
    public Card SQ = new Card(Rank.Queen, Suit.Spades);
    public Card SK = new Card(Rank.King, Suit.Spades);
    public Card SA = new Card(Rank.Ace, Suit.Spades);

    @Test
    public void getValue(){
        System.out.print(S2.toString());
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

        PokerHand hand01 = new PokerHand(C2, HA, S7, D2, C3);
    }
    @Test(expected = DuplicateCardException.class)
    public void tryToAddTheSameCardTwice() {

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
        assertEquals(HandRank.ThreeOfAKind ,threeDeuces01.getHandRank());

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
    @Test
    public void TwoPairTests(){


        PokerHand p20 = new PokerHand(S2, D2, S3, D3, SA);
        assertEquals(HandRank.TwoPair, p20.getHandRank() );
        assertEquals(0,p20.compareTo(p20) );

        PokerHand p21 = new PokerHand(S2, D2, S3, D3, SQ);
        assertEquals(1,p20.compareTo(p21) );

        PokerHand p22 = new PokerHand(S4, D4, S3, D3, SQ);
        assertEquals(-1,p20.compareTo(p22) );
        assertEquals(-1,p21.compareTo(p22) );

        PokerHand fh0 = new PokerHand(S2,H2,D8,H8,C8);
        assertEquals(HandRank.FullHouse ,fh0.getHandRank());

        PokerHand p23 = new PokerHand(S2, D2, SA, D3, S3);
        assertEquals(HandRank.TwoPair, p23.getHandRank() );
        assertEquals(0, p23.compareTo(p23) );

        PokerHand p24 = new PokerHand(S2, D2, SQ, S3, D3 );
        assertEquals(-1, p24.compareTo(p23) );

        PokerHand p25 = new PokerHand(S7, D7, SA, D3, S3);
        assertEquals(1, p25.compareTo(p23) );

        PokerHand p26 = new PokerHand(S2, D2, H2, C2, D3 );
        assertEquals(HandRank.FourOfAKind ,p26.getHandRank());

        PokerHand p27 = new PokerHand(S2, D2, D3, C2, H2 );
        assertEquals(HandRank.FourOfAKind ,p26.getHandRank());

        PokerHand p28 = new PokerHand(S7, D7, SA, D4, S4);
        assertEquals(-1, p25.compareTo(p28) );

        PokerHand p29 = new PokerHand(S4, D4, SA, D7, S7);
        assertEquals(-1, p25.compareTo(p29) );

        PokerHand p210 = new PokerHand(SA, D4, S4, D7, S7);
        assertEquals(HandRank.TwoPair, p210.getHandRank() );

        PokerHand p211 = new PokerHand(SQ, D5, S5, D7, S7);
        assertEquals(1, p211.compareTo(p210) );

        assertEquals(0, p211.compareTo(p211) );
        assertEquals(0, p28.compareTo(p29) );

        PokerHand p212 = new PokerHand(SQ, D5, S5, D4, S4);

        assertEquals(1, p211.compareTo(p212) );


    }
    @Test
    public void threeKindTests(){


        PokerHand tk00 = new PokerHand(S5, D5, H5, D7, S7);
        assertEquals(HandRank.FullHouse, tk00.getHandRank());


        tk00 = new PokerHand(S5, D5, H5, D7, S6);
        assertEquals(HandRank.ThreeOfAKind, tk00.getHandRank());

        PokerHand tk01 = new PokerHand(S5, D5, H5, D7, S6);
        assertEquals(0, tk01.compareTo(tk00) );

        tk01 = new PokerHand(S5, D5, H5, D8, S6);
        assertEquals(1, tk01.compareTo(tk00) );
        tk01 = new PokerHand(S5, D5, H5, D7, S8);
        assertEquals(1, tk01.compareTo(tk00) );
        tk01 = new PokerHand(S5, D5, H5, D6, S4);
        assertEquals(-1, tk01.compareTo(tk00) );
        tk01 = new PokerHand(S5, D5, H5, D7, S4);
        assertEquals(1, tk01.compareTo(tk00) );


        tk00 = new PokerHand(S6, D5, H5, S5, H6);
        assertEquals(HandRank.FullHouse, tk00.getHandRank());

        tk00 = new PokerHand(S7, D5, H5, S5, H6);
        tk01 = new PokerHand(D8, D5, H5, S5, S4);
        assertEquals(1, tk01.compareTo(tk00) );

        tk00 = new PokerHand(S3, D4, H5, S5, D5);
        tk01 = new PokerHand(D2, D3, H5, S5, D5);
        assertEquals(0, tk01.compareTo(tk01) );
        assertEquals(-1, tk01.compareTo(tk00) );
        assertEquals(HandRank.ThreeOfAKind, tk00.getHandRank());

    }
    @Test
    public void fullHouseTests(){


        PokerHand fh00 = new PokerHand(S5, D5, H7, D7, S7);
        assertEquals(HandRank.FullHouse, fh00.getHandRank());


        PokerHand fh01 = new PokerHand(H5, D5, S5, D7, S7);
        assertEquals(HandRank.FullHouse, fh00.getHandRank());

        assertEquals(-1, fh01.compareTo(fh00) );

        //FourKind

        PokerHand fk00 = new PokerHand(S5, C7, H7, D7, S7);
        assertEquals(HandRank.FourOfAKind, fk00.getHandRank());


        PokerHand fk01 = new PokerHand(H5, D5, S5, C5, S7);
        assertEquals(HandRank.FourOfAKind, fk01.getHandRank());

        assertEquals(-1, fk01.compareTo(fk00) );






    }
    @Test
    public void highCardTests() {


        PokerHand hc00 = new PokerHand(H5, D6, S8, C9, SA);
        assertEquals(HandRank.HighCard, hc00.getHandRank());

        PokerHand hc01 = new PokerHand(H4, D6, S8, C9, SA);
        assertEquals(HandRank.HighCard, hc01.getHandRank());
        assertEquals(1, hc00.compareTo(hc01));
        assertEquals(0, hc00.compareTo(hc00));

    }
    @Test
    public void straightTest() {


        PokerHand st00 = new PokerHand(H5, D6, S4, C3, S2);
        assertEquals(HandRank.Straight, st00.getHandRank());

        PokerHand st01 = new PokerHand(HA, DQ, S10, CJ, SK);
        assertEquals(HandRank.Straight, st01.getHandRank());
        assertEquals(14, st01.getKicker().get(0).getRank().getValue());

        PokerHand st02 = new PokerHand(HA, D2, S3, C4, S5);
        assertEquals(HandRank.Straight, st02.getHandRank());
        assertEquals(5, st02.getKicker().get(0).getRank().getValue());

        assertEquals(0,st00.compareTo(st00));
        assertEquals(0,st02.compareTo(st02));
        assertEquals(1,st01.compareTo(st02));




    }
    @Test
    public void flushTest() {




        PokerHand f00 = new PokerHand(HA, H8, H4, H3, H2);
        assertEquals(HandRank.Flush, f00.getHandRank());
        PokerHand f01 = new PokerHand(HK, H8, H4, H3, H2);
        assertEquals(1, f00.compareTo(f01));
        assertEquals(-1, f01.compareTo(f00));




    }
    @Test public void straightFlushTest(){
        PokerHand sf00 = new PokerHand(HA, H5, H4, H3, H2);
        assertEquals(HandRank.StraightFlush, sf00.getHandRank());

        PokerHand sf01 = new PokerHand(H6, H5, H4, H3, H2);
        assertEquals(HandRank.StraightFlush, sf01.getHandRank());

        assertEquals(-1, sf00.compareTo(sf01));

        PokerHand sf02 = new PokerHand(HK, H10, HQ, H9, HJ);
        assertEquals(HandRank.StraightFlush, sf02.getHandRank());

        PokerHand rf00 = new PokerHand(HK, H10, HQ, HA, HJ);
        assertEquals(HandRank.RoyalFLush, rf00.getHandRank());

        PokerHand rf01 = new PokerHand(CK, C10, CQ, CA, CJ);
        assertEquals(HandRank.RoyalFLush, rf01.getHandRank());

        assertEquals(0, rf01.compareTo(rf00));

    }
    @Test
    public void highCardTest(){
        PokerHand hc00 = new PokerHand(HA, S5, H6, H3, H2);
        assertEquals(HandRank.HighCard, hc00.getHandRank());
        PokerHand hc01 = new PokerHand(HK, S5, H6, H3, H2);
        assertEquals(1, hc00.compareTo(hc01));
        PokerHand hc02 = new PokerHand(HA, S5, H6, H3, H2);
        PokerHand hc03 = new PokerHand(HA, S5, H6, H3, S3);
        assertEquals(-1, hc02.compareTo(hc03));
    }
    @Test
    public void generalTests(){
        PokerHand highCard = new PokerHand(HA, S5, H6, H3, H2);
        PokerHand pairAces = new PokerHand(HA, SA, H6, H3, H2);
        PokerHand pairAcesKkicker = new PokerHand(HA, SA, H6, H3, HK);
        PokerHand TwopairAces = new PokerHand(HA, SA, S3, H3, H2);
        PokerHand threeKind = new PokerHand(S5, D5, H5, D6, S7);
        PokerHand straight = new PokerHand(S5, D6, H9, D7, S8);
        PokerHand flush = new PokerHand(S5, S6, S4, S2, S7);
        PokerHand fullHouse = new PokerHand(S5, D5, H5, D7, S7);
        PokerHand fourKind = new PokerHand(S5, D5, H5, C5, S7);
        PokerHand straightFlush = new PokerHand(SK, S9, S10, SJ, SQ);
        PokerHand royalFlush = new PokerHand(SK, S10, SA, SJ, SQ);

        assertEquals(1, royalFlush.compareTo(highCard));
        assertEquals(1, straightFlush.compareTo(pairAces));
        assertEquals(1, fourKind.compareTo(TwopairAces));
        assertEquals(1, fullHouse.compareTo(threeKind));
        assertEquals(1, flush.compareTo(straight));

        assertEquals(-1, highCard.compareTo(pairAces));
        assertEquals(-1, pairAces.compareTo(TwopairAces));
        assertEquals(-1, TwopairAces.compareTo(threeKind));
        assertEquals(-1, threeKind.compareTo(straight));
        assertEquals(-1, straight.compareTo(flush));
        assertEquals(-1, flush.compareTo(fullHouse));
        assertEquals(-1, fullHouse.compareTo(fourKind));
        assertEquals(-1, fourKind.compareTo(straightFlush));
        assertEquals(-1, straightFlush.compareTo(royalFlush));

        assertEquals(-1, pairAces.compareTo(pairAcesKkicker));

        List<PokerHand> list = new ArrayList<PokerHand>();
        list.add(fullHouse);
        list.add(pairAces);
        list.add(highCard);
        list.add(straightFlush);
        list.add(straight);
        list.add(royalFlush);
        list.add(TwopairAces);
        list.add(fourKind);
        list.add(threeKind);
        list.add(flush);
        for (PokerHand p: list)
            System.out.print(p.getHandRank() + " ");
        Collections.sort(list);
        System.out.println();
        for (PokerHand p: list)
            System.out.print(p.getHandRank() + " ");




    }




}//end Tests
