/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package blackjack;

/**
 *
 * @author hp
 */
import java.util.Scanner;
import java.util.Random;

public class Game {

    Scanner input = new Scanner(System.in);

    Player[] player = new Player[4];
    private Card[] cardDeck = new Card[52];
    int[] track = new int[4];
    private int counter;

    public void generateCard() {

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 9; j++) {
                Card c = new Card(i, j, j + 1);
                cardDeck[counter] = c;
                counter++;
            }
        }
        for (int i = 0; i < 4; i++) {
            for (int j = 9; j < 13; j++) {
                Card c = new Card(i, j, 10);
                cardDeck[counter] = c;
                counter++;
            }
        }
    }

    public Card drawCard() {
        Random rand = new Random();
        Card card = null;
        do {

            int cardChoice = rand.nextInt(51);
            card = cardDeck[cardChoice];
            cardDeck[cardChoice] = null;
        } while (card == null);
        return card;
    }

    public void setPlayer() {
        for (int i = 0; i < 3; i++) {
            System.out.println("Enter the name of player #" + (i + 1));
            player[i] = new Player();
            player[i].setName(input.next());
            for (int j = 0; j < 2; j++) {
                player[i].addCard(this.drawCard());
            }

        }
        player[3] = new Player();
        player[3].setName("Dealer");
        player[3].addCard(this.drawCard());
        player[3].addCard(this.drawCard());
    }

    public void updateMaxScore() {
        for (int i = 0; i < 4; i++) {
            if (player[i].getScore() <= 21) {
                track[i] = player[i].getScore();
            } else {
                track[i] = 0;
            }
        }
    }

    public Card[] getCardDeck() {
        return cardDeck;
    }
}
