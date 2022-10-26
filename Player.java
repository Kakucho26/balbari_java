package balbari;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Player {

    ArrayList<String[]> InitialHand(ArrayList<String[]> cardsAlpha, ArrayList<String[]> cardsDigit, ArrayList<String[]> cards52) {
        ArrayList<String[]> hand = new ArrayList<>();
        String[][] draw = {cardsAlpha.get(0), cardsAlpha.get(1), cardsDigit.get(0), cardsDigit.get(1)};
        for (String[] d: draw) {
            hand.add(d);
            cards52.remove(d);
            cardsAlpha.remove(d);
            cardsDigit.remove(d);
        }
        System.out.println("Initial hand");
        int i = 1;
        for (String[] h: hand) {
            System.out.println(i + ": " + h[0] +" "+ h[1]);
            i++;
        }
        return hand;
    }

    void Show(ArrayList<String[]> hand) {
        System.out.println("Your hand:");
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
        this.Show(hand);
    }

    //do-while로 발전시키기
    void Throw(ArrayList<String[]> hand) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please type the answer in 1-5.\nWhich card would you like to discard? 1-5 ");
        int number = scanner.nextInt();
        String[] selected = hand.get(number-1);
        hand.remove(selected);
    }

    boolean IsBalbari(ArrayList<String[]> hand, String[] alpha) {
        for (String[] h: hand) {
            if (Arrays.asList(alpha).contains(h[1])) {
                continue;
            }
            else {
                return false;
            }
        }
        return true;
    }

    void WinMessage(ArrayList<String[]> hand) {
        System.out.println("\n===Player Win===\n");
        int i = 1;
        for (String[] h: hand) {
            System.out.println(i + ": " + h[0] +" "+ h[1]);
            i++;
        }
    }
}

