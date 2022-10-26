package balbari;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Card {
    String[] suits = {"♠", "♥", "♦", "♣"};
    String[] nums = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
    String[] alpha = {"A", "J", "Q", "K"};
    String[] digit = {"2", "3", "4", "5", "6", "7", "8", "9", "10"};

    ArrayList<String[]> Cards52() {
        ArrayList<String[]> cards52 = new ArrayList<>();
        for (String suit: suits) {
            for (String num: nums) {
                String[] card = {suit, num};
                cards52.add(card);
            }
        }
        Collections.shuffle(cards52);
        return cards52;
    }

    ArrayList<String[]> CardsClassify(ArrayList<String[]> cards52, String[] classify) {
        ArrayList<String[]> cardsClassified = new ArrayList<>();
        for (String[] card: cards52) {
            if (Arrays.asList(classify).contains(card[1])) {
                cardsClassified.add(card);
            }
        }
        return cardsClassified;
    }

    public static void main(String[] args) {
        Card card = new Card();
        ArrayList<String[]> cards52 = card.Cards52();
        System.out.println(cards52.get(0)[0] +" "+ cards52.get(0)[1]);
    }

}
