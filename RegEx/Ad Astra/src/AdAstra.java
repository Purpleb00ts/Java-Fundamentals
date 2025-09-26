import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AdAstra {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String foodInfo = scanner.nextLine();

        String regex = "(#|\\|)(?<food>[A-Za-z\\s]+)\\1(?<date>[0-9]{2}\\/[0-9]{2}\\/[0-9]{2})\\1(?<calories>[0-9]{1,5})\\1";

        Pattern pattern = Pattern.compile(regex);

        Matcher matcher = pattern.matcher(foodInfo);

        List<String> items = new LinkedList<>();

        int cal = 0;

        while(matcher.find()){
                cal += Integer.parseInt(matcher.group("calories"));
                items.add(String.format("Item: %s, Best before: %s, Nutrition: %s", matcher.group("food"), matcher.group("date"), Integer.parseInt(matcher.group("calories"))));
        }

        System.out.printf("You have food to last you for: %d days!%n", cal / 2000);

        for (String item: items) {
            System.out.println(item);
        }
    }
}
