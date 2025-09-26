import java.util.Arrays;
import java.util.Scanner;

public class Sequence {
    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);

        int[] inputArr = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(e -> Integer.parseInt(e))
                .toArray();

        int counter = 0;
        int biggestSeq = 0;
        int index = 0;

        if(inputArr.length > 1) {
            for (int i = 0; i < inputArr.length; i++) {
                if (counter > biggestSeq) {
                    biggestSeq = counter;
                    index = i - biggestSeq - 1;
                }
                counter = 0;
                for (int j = i + 1; j < inputArr.length; j++) {
                    if (inputArr[j] == inputArr[i]) {
                        counter++;
                        i++;
                    } else {
                        break;
                    }
                }
            }
        }
        else{
            System.out.println(inputArr[0]);
            return;
        }
        if(counter > biggestSeq){
            biggestSeq = counter;
            index = inputArr.length - biggestSeq - 1;
        }

        for (int i = 0; i <= biggestSeq; i++) {
            System.out.printf("%d ", inputArr[i + index]);
        }
    }
}
