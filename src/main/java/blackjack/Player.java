/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package blackjack;

/**
 *
 * @author hp
 */
public class Player {

    private String Name;
    private int Score;
    private Card[] card = new Card[11];
    private int counter = 0;

    public void setName(String Name) {
        this.Name = Name;
    }

    public void addCard(Card c) {
        if (counter < 11) {
            this.card[counter] = c;
            counter++;
            Score += c.getValue();
        }

    }

    public void setScore(int Score) {
        this.Score = Score;
    }

    public String getName() {
        return Name;
    }

    public int getScore() {
        return Score;
    }

    public Card[] getCard() {
        return card;
    }
}
