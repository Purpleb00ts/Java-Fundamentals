import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Text {
    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);

        String input = scanner.nextLine();

        LinkedHashMap<Character, Integer> countChar = new LinkedHashMap<>();

        for (char symbol : input.toCharArray()) {
            if(symbol == ' '){
                continue;
            }

            if(countChar.containsKey(symbol)){
                countChar.put(symbol, countChar.get(symbol) + 1);
            }

            else{
                countChar.put(symbol, 1);
            }
        }

        for (Map.Entry<Character, Integer> entry : countChar.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }

       // countChar.forEach((key, value) -> System.out.println(key + " -> " + value)); same as the for each above
    }
}
