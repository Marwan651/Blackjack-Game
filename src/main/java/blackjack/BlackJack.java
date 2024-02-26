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

public class BlackJack {

    static Game game = new Game();

    public static void main(String[] args) {
        GUI gui = new GUI();
        game.generateCard();
        game.setPlayer();
        gui.runGUI(game.getCardDeck(),
                game.player[0].getCard(),
                game.player[1].getCard(),
                game.player[2].getCard(),
                game.player[3].getCard());

        playerTurn(gui);
        game.updateMaxScore();
        dealerTurn(gui);
        game.updateMaxScore();
        if (checkPush(gui)) {
            playerScore();
            System.out.println("**Push Case**");
        } else {
            getResult(gui);
        }
    }

    public static void playerTurn(GUI gui) {
        Scanner input = new Scanner(System.in);
        for (int i = 0; i < 3; i++) {
            System.out.println("Turn of player #" + (i + 1));
            int choice = 1;
            while (choice == 1 && !checkLost(gui, i)) {
                System.out.println("**press 1 to Hit and 2 to Stand**");
                choice = input.nextInt();
                switch (choice) {
                    case 1 ->
                        addCardToPlayer(i, gui);
                    case 2 -> {
                    }
                }
            }
        }
    }

    public static void addCardToPlayer(int i, GUI gui) {
        Card card = game.drawCard();
        game.player[i].addCard(card);
        gui.updatePlayerHand(card, i);
    }

    public static void dealerTurn(GUI gui) {
        boolean win = false;
        int highScore = 0;
        for (int i = 0; i < 3; i++) {
            if (game.track[i] > game.player[3].getScore()) {
                win = false;
            }
            if (game.track[i] > highScore) {
                highScore = game.track[i];
            }
        }
        if (!win) {
            addCardToDealer(gui, highScore);
        }
    }

    public static void addCardToDealer(GUI gui, int highScore) {
        while (game.player[3].getScore() <= highScore) {
            Card card = game.drawCard();
            game.player[3].addCard(card);
            gui.updateDealerHand(card, game.getCardDeck());
        }
    }

    public static int getResult(GUI gui) {
        int HIGHSCORE = 0;
        int index = 0;
        for (int i = 0; i < 4; i++) {
            System.out.println(game.player[i].getName() + "'s score is " + game.player[i].getScore());
            if (checkLost(gui, i)) {
                game.player[i].setScore(0);
                System.out.println("Busted");
            } else if (game.player[i].getScore() > HIGHSCORE) {
                HIGHSCORE = game.player[i].getScore();
                index = i;
            }
        }
        System.out.println("The winner is " + game.player[index].getName());
        System.out.println("High score is " + HIGHSCORE);
        return HIGHSCORE;
    }

    public static boolean checkLost(GUI gui, int index) {
        if (game.player[index].getScore() > 21) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean checkPush(GUI gui) {
        int HIGHSCORE = 0;
        boolean push = false;
            for (int i = 0; i < 4; i++) {
                if (game.player[i].getScore() > HIGHSCORE && !checkLost(gui, i)) {
                    HIGHSCORE = game.player[i].getScore();
                }
            }
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    if (HIGHSCORE == game.player[i].getScore()) {
                        if (i == j) {
                            continue;
                        }
                        if (game.player[i].getScore() == game.player[j].getScore()) {
                            push = true;
                            break;
                        }
                    }
                }
            }
        return push;
    }

    public static void playerScore() {
        for (int i = 0; i < 4; i++) {
            System.out.println(game.player[i].getName() + "'s score is " + game.player[i].getScore());
        }
    }
}
