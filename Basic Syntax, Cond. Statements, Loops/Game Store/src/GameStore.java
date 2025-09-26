import java.util.Scanner;
public class GameStore {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        float budget = Float.parseFloat(sc.nextLine());
        String gamename = sc.nextLine();
        while (!gamename.equals("Game Time!"))
        {
            if(budget <= 0)
            {
                System.exit(0);
            }
            switch (gamename){
                case "OutFall 4":
                    if(budget - 39.99 >= 0)
                    {
                        budget -= 39.99;
                        System.out.println("Bought OutFall 4");
                    }
                    else
                    {
                        System.out.println("Too Expensive, can't afford");
                    }
                    break;
                case "Zplinter Zell":
                    if(budget - 19.99 >= 0)
                    {
                        budget -= 19.99;
                        System.out.println("Bought Zplinter Zell");
                    }
                    else
                    {
                        System.out.println("Too Expensive, can't afford");
                    }
                    break;
                case "CS: OG":
                    if(budget - 15.99 >= 0)
                    {
                        budget -= 15.99;
                        System.out.println("Bought CS: OG");
                    }
                    else
                    {
                        System.out.println("Too Expensive, can't afford");
                    }
                    break;
                case "Honored 2":
                    if(budget - 59.99 >= 0)
                    {
                        budget -= 59.99;
                        System.out.println("Bought Honored 2");
                    }
                    else
                    {
                        System.out.println("Too Expensive, can't afford");
                    }
                    break;
                case "RoverWatch":
                    if(budget - 29.99 >= 0)
                    {
                        budget -= 29.99;
                        System.out.println("Bought RoverWatch");
                    }
                    else
                    {
                        System.out.println("Too Expensive, can't afford");
                    }
                    break;
                case "RoverWatch Origins Edition":
                    if(budget - 39.99 >= 0)
                    {
                        budget -= 39.99;
                        System.out.println("Bought RoverWatch Origins Edition");
                    }
                    else
                    {
                        System.out.println("Too Expensive, can't afford");
                    }
                    break;

                default:
                    System.out.println("Not Found");
            }
            gamename = sc.nextLine();
        }
        System.out.printf("Thanks for buying the games, here is the rest of your money: %.02f", budget);
    }
}
