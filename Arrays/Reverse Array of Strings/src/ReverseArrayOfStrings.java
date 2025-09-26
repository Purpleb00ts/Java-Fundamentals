import java.util.Scanner;

public class ReverseArrayOfStrings {
    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);
        
        String input = scanner.nextLine();
        
        String[] inputArr = input.split(" ");

        for (int i = 0; i <= inputArr.length/2; i++) {
            String temp = inputArr[i];
            inputArr[i] = inputArr[inputArr.length - i - 1];
            inputArr[inputArr.length - i - 1] = temp;
        }

//        for (int i = 0; i < inputArr.length; i++) {
//            System.out.println(inputArr[i]);
//        }
        // String.join() connects elements of an array of Strings
        System.out.println(String.join(" ", inputArr));
    }
}
