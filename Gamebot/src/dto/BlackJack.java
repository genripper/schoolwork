package dto;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Jake
 */
public class BlackJack implements Game
{

    public String getName()
    {
        return "BlackJack";
    }

    public void run()
    {
        Scanner kb = new Scanner(System.in);
        Random r = new Random();

        int card1 = 2 + r.nextInt(11), card2 = 2 + r.nextInt(11), dealerCard1 = 2 + r.nextInt(11), dealerCard2 = 2 + r.nextInt(11), newCard, playerTotal = card1 + card2, dealerTotal = dealerCard1 + dealerCard2;
        String userInput = "";
        boolean hitFlag, dealerBust = false, playerBust = false;

        System.out.println("Black Jack");
        System.out.println("You get a " + card1 + " and a " + card2 + ".");
        System.out.println("Your total is " + playerTotal + ".\n");

        System.out.println("The dealer has a " + dealerCard1 + " showing, and a hidden card.");
        System.out.println("His total is hidden, too.\n");

        do
        {
            System.out.print("Would you like to \"hit\" or \"stay\"? ");
            userInput = kb.next();

            if (userInput.equalsIgnoreCase("hit"))
            {
                hitFlag = true;
                newCard = 2 + r.nextInt(11);
                System.out.println("You drew a " + newCard);
                playerTotal += newCard;
                if (playerTotal > 21)
                {
                    System.out.println("You bust!\nDealer wins");
                    hitFlag = false;
                    playerBust = true;
                } else
                {
                    System.out.println("Your total is " + playerTotal);
                }
            } else
            {
                hitFlag = false;
                System.out.println("\nOkay, dealer's turn.");
                System.out.println("His hidden card was  a " + dealerCard2 + " .");
                System.out.println("His total is " + dealerTotal);
            }
        } while (hitFlag == true);

        if (playerBust == false)
        {
            while (dealerTotal < 21)
            {
                System.out.println("\nDealer chooses to hit.");
                newCard = 2 + r.nextInt(11);
                System.out.println("He draws a " + newCard + " .");
                dealerTotal += newCard;
                System.out.println("His total is " + dealerTotal);
                if (dealerTotal > 21)
                {
                    System.out.println("Dealer busts");
                    System.out.println("\nYou Win");
                    dealerBust = true;
                    break;
                } else
                {
                    if (dealerTotal > 16 && dealerTotal < 22)
                    {
                        System.out.println("\nDealer stays.");
                        break;
                    }
                }
            }

            if (dealerBust == false)
            {
                System.out.println("\nDealer Total is " + dealerTotal + "  .");
                System.out.println("Your total is " + playerTotal + " .\n");

                if (playerTotal > dealerTotal)
                {
                    System.out.println("YOU WIN!");
                } else
                {
                    if (playerTotal == dealerTotal)
                    {
                        System.out.println("Push");
                    } else
                    {
                        System.out.println("Dealer wins");
                    }
                }
            }
        }

    }

}
