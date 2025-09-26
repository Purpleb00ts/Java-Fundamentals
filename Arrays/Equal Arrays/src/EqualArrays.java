import java.util.Arrays;
import java.util.Scanner;

public class EqualArrays {
    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);
        
        String firstInput = scanner.nextLine();
        
        String secondInput = scanner.nextLine();
        
        int[] firstInputArr = Arrays.stream(firstInput.split(" ")).mapToInt(e -> Integer.parseInt(e)).toArray();

        int[] secondInputArr = Arrays.stream(secondInput.split(" ")).mapToInt(e -> Integer.parseInt(e)).toArray();

        boolean flag = true;

        int difference = 0;

        for (int i = 0; i < firstInputArr.length; i++) {
            if(firstInputArr[i] == secondInputArr[i])
                flag = true;
            else {
                flag = false;
                difference = i;
                break;
            }
        }

        int sum = 0;

        if(flag == true){
            for (int i = 0; i < firstInputArr.length; i++) {
                sum += firstInputArr[i];
            }
            System.out.printf("Arrays are identical. Sum: %d", sum);
        }
        else{
            System.out.printf("Arrays are not identical. Found Difference at %d index", difference);
        }
    }
}
