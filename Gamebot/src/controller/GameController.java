package controller;

import dto.BlackJack;
import dto.Game;
import dto.LuckySevens;
import dto.RockPaperScissors;
import java.util.ArrayList;
import ui.ConsoleIO;

/**
 *
 * @author Jake
 */
public class GameController {

    ConsoleIO ui = new ConsoleIO();
    ArrayList<Game> games = new ArrayList<>();

    public void run() {

        games.add(new BlackJack());
        games.add(new LuckySevens());
        games.add(new RockPaperScissors());

        int choice;

       do {
            menu();
            choice = ui.readInteger(" \n Enter the number of the game that you want to play. ", 1, games.size() + 1);
            ui.write("\n");
            if(choice != games.size() + 1) {
                games.get(choice - 1).run();
            }

        } while (choice != games.size() + 1);

    }

    public void menu() {

        ui.write("\n\n");
        ui.write("------------------------------------\n");
        ui.write("\t      GAMEBOT\n");
        
        for (int i = 1; i <= games.size(); i++) {

            ui.write(i + ") " + games.get(i - 1).getName() + "\n");
        }

        ui.write((games.size() + 1) + ") Exit \n");

    }
}
