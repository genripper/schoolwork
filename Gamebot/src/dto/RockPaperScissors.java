
package dto;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Jake
 */
public class RockPaperScissors implements Game
{
    public static Scanner kb = new Scanner(System.in);
    
    public String getName()
    {
        return "Rock Paper Scissors";
    }
    
    
   
   public void run()
    {
        menu();
        gameInterface();
    }
    
    public static void menu()
    {
        System.out.println("Rock Paper Scissors \n");
        System.out.println("1. Rock");
        System.out.println("2. Paper");
        System.out.println("3. Scissors \n");
    }
    
    public static void gameInterface()
    {
        int choice, maxRounds, ties = 0, userWins = 0, compWins = 0;
        boolean cont = true;
        String result, play;
        
      
        
        while(cont)
        {
            System.out.println("How many rounds would you like to play (1-10)?");
            maxRounds = takeInInt();
 

            if (checkMaxRounds(maxRounds))
            {
                for (int i = 0; i < maxRounds; i++)
                {
                    System.out.println("\nGame time. Enter your choice by selecting the number.");
                    choice = gameChoice();
                    result = play(choice);
                    if (result.equalsIgnoreCase("Tie"))
                    {
                        ties++;
                    }
                    if (result.equalsIgnoreCase("lose"))
                    {
                        compWins++;
                    }
                    if (result.equalsIgnoreCase("win"))
                    {
                        userWins++;
                    }
                }
                if (userWins > compWins)
                {
                    System.out.println("You are the winner.");
                }
                if (userWins < compWins)
                {
                    System.out.println("The computer is the winner.");
                }
                if (userWins == compWins)
                {
                    System.out.println("User ties the computer.");
                }
                System.out.println("User wins: " + userWins);
                System.out.println("Computer wins: " + compWins);
                System.out.println("Ties: " + ties);
            } else
            {
                System.out.println("Error, not a legal number.");
            }
            
            System.out.println("Do you want to play again? Yes or No");
            play = kb.nextLine();
            
            if (play.equalsIgnoreCase("no"))
                cont = false;
            
            ties = 0;
            userWins = 0;
            compWins = 0;
        }
    }
    
   
    public static String play(int x)
    {
        Random rGen = new Random();
        
        menu();


        int opponentChoice = rGen.nextInt(3) + 1;

        switch (opponentChoice)
        {
            case (1):
                System.out.println("The computer picked: Rock \n");
                break;
            case (2):
                System.out.println("The computer picked: Paper \n");
                break;
            case (3):
                System.out.println("The computer picked: Scissors \n");
                break;
        }
        switch (x)
        {
            case (1):
                if (opponentChoice == 1)
                {
                    System.out.println("Tie. You have both picked Rock");
                    return "Tie";
                } else if (opponentChoice == 2)
                {
                    System.out.println("You lose. Paper beats Rock.");
                    return "lose";
                } else if (opponentChoice == 3)
                {
                    System.out.println("You win. Rock beats Scissors.");
                    return "win";
                }
                break;
            case (2):
                if (opponentChoice == 2)
                {
                    System.out.println("Tie. You have both picked Paper");
                    return "Tie";
                } else if (opponentChoice == 3)
                {
                    System.out.println("You lose. Scissors beats Paper.");
                    return "lose";
                } else if (opponentChoice == 1)
                {
                    System.out.println("You win. Paper beats Rock.");
                    return "win";
                }
                break;
            case (3):
                if (opponentChoice == 3)
                {
                    System.out.println("Tie. You have both picked Scissors");
                    return "Tie";
                } else if (opponentChoice == 1)
                {
                    System.out.println("You lose. Rock beats Scissors.");
                    return "lose";
                } else if (opponentChoice == 2)
                {
                    System.out.println("You win. Scissors beats paper.");
                    return "win";
                }
                break;
            default:
                System.out.println("Please pick a valid choice.");

        }
        return " ";
    }
    
    public static int gameChoice()
    {
        boolean flag = true;
        int temp, result = 0;
        
        while (flag)
        {
            temp = takeInInt();
            if (temp != -1)
            {
                if (validChoice(temp))
                {
                    result = temp;
                    flag = false;
                }
                else System.out.println("Please enter 1 - 3 for Rock, Paper, and "
                        + "Scissors respectively. ");
            }
            else
            {
                kb.nextLine();
                System.out.println("Error. Please enter an integer.");
            }
        }
        
        return result;      
    }
    
    public static int takeInInt()
    {
        int t = -1;
        if (kb.hasNextInt())
            t = Integer.parseInt(kb.nextLine());
        return t;
    }
    
    public static boolean checkMaxRounds(int x)
    {
       return ((x >= 1) && (x <= 10));
    }
 
    
    
    public static boolean validChoice(int x)
    {
       return ((x > 0) && (x < 4));
    }
}
