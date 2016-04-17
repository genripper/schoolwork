package dto;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Jake
 */
public class LuckySevens implements Game
{

    public String getName()
    {
        return "Lucky Sevens";
    }

    public void run()
    {
        Scanner kb = new Scanner(System.in);
        Random rGen = new Random();
        int counter = 0;
        int maxMoney = 0;
        int maxMoneyCounter = 0;
        int wallet;
        System.out.print("How much would you like to bet? ");
        wallet = Integer.parseInt(kb.nextLine());

        do
        {
            int d1 = rGen.nextInt(6) + 1;
            int d2 = rGen.nextInt(6) + 1;
            int sum = d1 + d2;
            counter++;
            if (sum == 7)
            {
                wallet += 4;
                if (wallet >= maxMoney)
                {
                    maxMoney = wallet;
                    maxMoneyCounter = counter;
                }
            } else
            {
                wallet -= 1;
            }
        } while (wallet > 0);
        System.out.println("You are broke after: " + counter + " rolls");
        System.out.println("You should have quit after roll: " + maxMoneyCounter + " when you had: " + maxMoney);
    }
}
