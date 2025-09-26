import java.util.Scanner;
public class Clock {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int hours = Integer.parseInt(sc.nextLine());
        int minutes = Integer.parseInt(sc.nextLine());

        minutes += 30;

        if(minutes >= 60) {
            minutes -= 60;
            hours++;

            if(hours >= 24) {
                hours -= 24;
            }

            System.out.printf ("%d:%d", hours, minutes);
        }
        else {
            System.out.printf ("%d:%d", hours, minutes);
        }
    }
}
