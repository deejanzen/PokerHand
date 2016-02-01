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

    public double payout(Integer winners){
        return pot / winners;
    }

    public void clearPot(){
        pot = 0;
    }

    public void shuffle(){
        marker = 0;
        Collections.shuffle(deck);
    }
    public Card deal(){
        return deck.get(marker++);
    }//new Random 0 to 52 instead of shuffle??

    public List<Card> getCommonHand(){
        List<Card> commonHand = new ArrayList<>();
        for (int i = 0; i < 5;i++){
            commonHand.add(deal());
        }
        Collections.sort(commonHand);
        return commonHand;
    }

    public PokerHand determineBestHand(List<Card> player, List<Card> common ){
        List<PokerHand> hands = new ArrayList<>();
        //Create all 21 PokerHands & add them to a List<PokerHand>

        //0 5 = player.get(0) 6 = player.get(1)
        hands.add( new PokerHand(common.get(0),common.get(1),common.get(2),common.get(3),common.get(4)) );
        //1
        hands.add( new PokerHand(player.get(0),common.get(1),common.get(2),common.get(3),common.get(4)) );
        //2
        hands.add( new PokerHand(common.get(0),player.get(0),common.get(2),common.get(3),common.get(4)) );
        //3
        hands.add( new PokerHand(common.get(0),common.get(1),player.get(0),common.get(3),common.get(4)) );
        //4
        hands.add( new PokerHand(common.get(0),common.get(1),common.get(2),player.get(0),common.get(4)) );
        //5
        hands.add( new PokerHand(common.get(0),common.get(1),common.get(2),common.get(3),player.get(0)) );
        //6
        hands.add( new PokerHand(player.get(1),common.get(1),common.get(2),common.get(3),common.get(4)) );
        //7
        hands.add( new PokerHand(common.get(0),player.get(1),common.get(2),common.get(3),common.get(4)) );
        //8
        hands.add( new PokerHand(common.get(0),common.get(1),player.get(1),common.get(3),common.get(4)) );
        //9
        hands.add( new PokerHand(common.get(0),common.get(1),common.get(2),player.get(1),common.get(4)) );
        //10
        hands.add( new PokerHand(common.get(0),common.get(1),common.get(2),common.get(3),player.get(1)) );
        //11
        hands.add( new PokerHand(player.get(0),player.get(1),common.get(2),common.get(3),common.get(4)) );
        //12
        hands.add( new PokerHand(common.get(0),player.get(0),player.get(1),common.get(3),common.get(4)) );
        //13
        hands.add( new PokerHand(common.get(0),common.get(1),player.get(0),player.get(1),common.get(4)) );
        //14
        hands.add( new PokerHand(common.get(0),common.get(1),common.get(2),player.get(0),player.get(1)) );
        //15
        hands.add( new PokerHand(player.get(0),common.get(1),player.get(1),common.get(3),common.get(4)) );
        //16
        hands.add( new PokerHand(player.get(0),common.get(1),common.get(2),player.get(1),common.get(4)) );
        //17
        hands.add( new PokerHand(player.get(0),common.get(1),common.get(2),common.get(3),player.get(1)) );
        //18
        hands.add( new PokerHand(common.get(0),player.get(0),common.get(2),player.get(1),common.get(4)) );
        //19
        hands.add( new PokerHand(common.get(0),player.get(0),common.get(2),common.get(3),player.get(1)) );
        //20
        hands.add( new PokerHand(common.get(0),common.get(1),player.get(0),common.get(3),player.get(1)) );

        //sort list
        Collections.sort(hands);
        //return get last
        return hands.get(20);
    }

    public List<Integer> getTopIndices(ArrayList<Player> playersList) {
        List<Integer> topIndices =  new ArrayList<>();
        int maxHandRankValue = -1;
        for (int i = 0; i < playersList.size();i++){
            if (playersList.get(i).getBestHand().getHandRank().getValue() > maxHandRankValue)
                maxHandRankValue = playersList.get(i).getBestHand().getHandRank().getValue();
        }
        for (int i = 0; i < playersList.size();i++){
            if (playersList.get(i).getBestHand().getHandRank().getValue() == maxHandRankValue)
                topIndices.add(i);
        }


        return topIndices;
    }
}
