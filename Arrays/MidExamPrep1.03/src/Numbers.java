import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Numbers {
    public static int averageValue(int[] arr){
        int averageValue = 0;
        for (int i = 0; i < arr.length; i++) {
            averageValue += arr[i];
        }

        averageValue /= arr.length;

        return averageValue;
    }

    public static List<Integer> sortedList (int[] arr, int averageValue)
    {
        List<Integer> greaterThanAvg = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {
            if(arr[i] > averageValue){
                greaterThanAvg.add(arr[i]);
            }
        }

        int max = 0;

        for (int i = 0; i < greaterThanAvg.size(); i++) {
            max = greaterThanAvg.get(i);
            for (int j = 0; j < greaterThanAvg.size(); j++) {
                if(max > greaterThanAvg.get(j))
                {
                    max = greaterThanAvg.get(j);
                    greaterThanAvg.set(j, greaterThanAvg.get(i));
                    greaterThanAvg.set(i, max);
                }
            }
        }

        return greaterThanAvg;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);

        String input = scanner.nextLine();

        int[] inputArr = Arrays.stream(input.split(" "))
                .mapToInt(e -> Integer.parseInt(e))
                .toArray();

        int averageValue = averageValue(inputArr);

        if(sortedList(inputArr,averageValue).size() == 0){
            System.out.printf("No");
            return;
        }

        if(sortedList(inputArr,averageValue).size() >= 5){
            for (int i = 0; i < 5; i++) {
                System.out.printf("%d ", sortedList(inputArr, averageValue).get(i));
            }
        }
        else{
            for (int el: sortedList(inputArr,averageValue)) {
                System.out.printf("%d ", el);
            }
        }
    }
}
