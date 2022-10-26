package balbari;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Computer extends Player{

    @Override
    ArrayList<String[]> InitialHand(ArrayList<String[]> cardsAlpha, ArrayList<String[]> cardsDigit, ArrayList<String[]> cards52) {
        ArrayList<String[]> hand = new ArrayList<>();
        String[][] draw = {cardsAlpha.get(0), cardsAlpha.get(1), cardsDigit.get(0), cardsDigit.get(1)};
        for (String[] d: draw) {
            hand.add(d);
            cards52.remove(d);
            cardsAlpha.remove(d);
            cardsDigit.remove(d);
        }
        return hand;
    }


    @Override
    void Show(ArrayList<String[]> hand) {
        System.out.println("Computer's hand:");
        int i = 1;
        for (String[] h: hand) {
            System.out.println(i + ": " + h[0] +" "+ h[1]);
            i++;
        }
    }

    void Draw(ArrayList<String[]> cardsAlpha, ArrayList<String[]> cardsDigit, ArrayList<String[]> cards52, ArrayList<String[]> hand) {
        Random r = new Random();
        int rand = r.nextInt(cards52.size());
        String[] card = cards52.get(rand);
        hand.add(card);
        cards52.remove(card);
        cardsAlpha.remove(card);
        cardsDigit.remove(card);
    }

    void AutoThrow(ArrayList<String[]> hand, String[] alpha) {
        for (String[] h: hand) {
            if (!Arrays.asList(alpha).contains(h[1])) {
                hand.remove(h);
                break;
            }
        }
    }
    
    @Override
    void WinMessage(ArrayList<String[]> hand) {
        System.out.println("\n===Computer Win===\n");
        int i = 1;
        for (String[] h: hand) {
            System.out.println(i + ": " + h[0] +" "+ h[1]);
            i++;
        }
    }



}
