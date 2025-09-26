import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class TreasureHunt {
    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);

        String input = scanner.nextLine();

        List<String> inputArr = Arrays.stream(input.split("\\|"))
                .collect(Collectors.toList());

        String loot = scanner.nextLine();

        int length = inputArr.size();

        float sum = 0;



        while(!loot.equals("Yohoho!"))
        {
            String[] lootArr = loot.split(" ");


            length = inputArr.size();

            if(lootArr[0].equals("Loot"))
            {
                for (int i = 1; i < lootArr.length; i++) {
                    if(!inputArr.contains(lootArr[i])) {
                        inputArr.add(0, lootArr[i]);
                    }
                }
            }

            if(lootArr[0].equals("Steal") && Integer.parseInt(lootArr[1]) <= inputArr.size() && Integer.parseInt(lootArr[1]) > 0){
                for (int i = 0; i < Integer.parseInt(lootArr[1]); i++) {
                    if(i == Integer.parseInt(lootArr[1]) - 1)
                    {
                        System.out.printf("%s%n", inputArr.get(inputArr.size() - Integer.parseInt(lootArr[1]) + i));
                    }
                    else{
                        System.out.printf("%s, ", inputArr.get(inputArr.size() - Integer.parseInt(lootArr[1]) + i));
                    }
                    inputArr.remove(inputArr.size() - Integer.parseInt(lootArr[1]) + i);
                }
            }
            else if(lootArr[0].equals("Steal") && Integer.parseInt(lootArr[1]) > inputArr.size() && Integer.parseInt(lootArr[1]) > 0 && Integer.parseInt(lootArr[1]) <= 100 && Integer.parseInt(lootArr[1]) > 0){
                for (int i = 0; i < length; i++) {
                    if(i == length - 1)
                    {
                        System.out.printf("%s%n", inputArr.get(0));
                    }
                    else{
                        System.out.printf("%s, ", inputArr.get(0));
                    }
                    inputArr.remove(0);
                }
            }

            if(lootArr[0].equals("Drop") && Integer.parseInt(lootArr[1]) >= 0 && Integer.parseInt(lootArr[1]) < inputArr.size()){
                inputArr.add(inputArr.get(Integer.parseInt(lootArr[1])));
                inputArr.remove(Integer.parseInt(lootArr[1]));
            }

            if(inputArr.size() == 0)
            {
                System.out.printf("Failed treasure hunt.");
                return;
            }

            loot = scanner.nextLine();
        }

        for (int i = 0; i < inputArr.size(); i++) {
            sum += inputArr.get(i).length();
        }

        sum /= inputArr.size();

        System.out.printf("Average treasure gain: %.2f pirate credits.", sum);
    }
}
