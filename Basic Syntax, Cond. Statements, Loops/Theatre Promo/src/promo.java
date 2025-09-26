import java.util.Scanner;
public class promo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String day = sc.nextLine();
        int age = Integer.parseInt(sc.nextLine());

        switch (day){
            case "Weekday":
                if(age <= 18)
                {
                    System.out.println("12$");
                }
                else if(age > 18 && age <= 64)
                {
                    System.out.println("18$");
                }
                else if(age > 64 && age <= 122)
                {
                    System.out.println("12$");
                }
                break;
            case "Weekend":
                if(age <= 18)
                {
                    System.out.println("15$");
                }
                else if(age > 18 && age <= 64)
                {
                    System.out.println("20$");
                }
                else if(age > 64 && age <= 122)
                {
                    System.out.println("15$");
                }
                break;
            case "Holiday":
                if(age <= 18)
                {
                    System.out.println("5$");
                }
                else if(age > 18 && age <= 64)
                {
                    System.out.println("12$");
                }
                else if(age > 64 && age <= 122)
                {
                    System.out.println("10$");
                }
                break;

        }
    }
}
