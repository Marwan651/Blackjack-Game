/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package blackjack;

/**
 *
 * @author hp
 */
public class Card {

    final private int suit;
    final private int rank;
    final private int value;

    public Card(int s, int r, int v) {
        suit = s;
        rank = r;
        value = v;
    }

    public Card(Card c) {
        suit = c.suit;
        rank = c.rank;
        value = c.value;
    }

    public int getSuit() {
        return suit;
    }

    public int getRank() {
        return rank;
    }

    public int getValue() {
        return value;
    }
}
