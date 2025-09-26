import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmojiDetector {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();

        String regex = "(?<emoji>(::|\\*\\*)(?<name>[A-Z][a-z]{2,})\\2)";

        Pattern pattern = Pattern.compile(regex);

        Matcher matcher = pattern.matcher(text);

        int coolnessThreshold = 1;



        int cntOfEmojis = 0;

        for (int i = 0; i < text.length(); i++) {
            if(Character.isDigit(text.charAt(i))){
                coolnessThreshold *= Integer.parseInt(text.substring(i, i + 1));
            }
        }

        System.out.printf("Cool threshold: %d%n", coolnessThreshold);

        while(matcher.find()){
            cntOfEmojis++;
        }

        matcher = pattern.matcher(text);

        System.out.printf("%d emojis found in the text. The cool ones are: %n", cntOfEmojis);

        while(matcher.find()){
            int coolnessOfEmoji = 0;
            for (int i = 0; i < matcher.group("name").length(); i++) {
                int ascii = matcher.group("name").charAt(i);
                coolnessOfEmoji += ascii;
            }
            if(coolnessOfEmoji >= coolnessThreshold){
                System.out.println(matcher.group("emoji"));
            }
        }
    }
}
