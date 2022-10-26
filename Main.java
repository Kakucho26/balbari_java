package balbari;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Card card = new Card();
        Player player = new Player();
        Computer computer = new Computer();

        ArrayList<String[]> cards52 = card.Cards52();
        String[] alpha = card.alpha;
        ArrayList<String[]> cardsAlpha = card.CardsClassify(cards52, card.alpha);
        ArrayList<String[]> cardsDigit = card.CardsClassify(cards52, card.digit);

        System.out.println("===Welcome to Balbari!===\n");
        System.out.println("GOAL: all of your 4 cards in your hand are A, J, Q, or K (which is called Balbari.)");
        System.out.println("\nRULES\n");
        System.out.println("* each player (You and Computer) get 4 cards.");
        System.out.println("* each round, each player get 1 card more.");
        System.out.println("* each player throw 1 card from their hand.");
        System.out.println("* you win if you get Balbari within 5 rounds.\n");


        ArrayList<String[]> hand_player = player.InitialHand(cardsAlpha, cardsDigit, cards52);
        ArrayList<String[]> hand_computer = computer.InitialHand(cardsAlpha, cardsDigit, cards52);
        
        boolean tie = true;

        for (int i=1; i<=5; i++) {
            System.out.printf("%nRound %d %n", i);
            player.Draw(cardsAlpha, cardsDigit, cards52, hand_player);
            player.Throw(hand_player);
            computer.Draw(cardsAlpha, cardsDigit, cards52, hand_computer);
            computer.AutoThrow(hand_computer, alpha);
            boolean win_player = player.IsBalbari(hand_player, alpha);
            boolean win_computer = player.IsBalbari(hand_computer, alpha);
            if (win_player) {
                player.WinMessage(hand_player);
                tie = false;
                break;
            }
            else if (win_computer) {
                computer.WinMessage(hand_computer);
                tie = false;
                break;
            }
            else {
                continue;
            }
        }
        if (tie) {
            computer.WinMessage(hand_computer);
        }
    }
}
