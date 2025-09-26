import java.util.Scanner;

public class Password {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String inputPassword = scanner.nextLine();



        String commands = scanner.nextLine();

        while(!commands.equals("Done")){
            String[] command = commands.split(" ");

            switch (command[0]){
                case "TakeOdd":
                    StringBuilder oddPassword = new StringBuilder();
                    for (int i = 1; i < inputPassword.length(); i+=2) {
                        oddPassword.append(inputPassword.charAt(i));
                    }
                    inputPassword = oddPassword.toString();
                    System.out.println(inputPassword);
                    break;
                case "Cut":
                    int index = Integer.parseInt(command[1]);
                    int length = Integer.parseInt(command[2]);
                    StringBuilder cutPassword = new StringBuilder();
                    cutPassword.append(inputPassword);
                    cutPassword.delete(index, index + length);
                    inputPassword = cutPassword.toString();
                    System.out.println(inputPassword);
                    break;
                case "Substitute":
                    String substring = command[1];
                    String substitute = command[2];
                    boolean flag = false;
                    while (inputPassword.contains(substring)){
                        inputPassword = inputPassword.replace(substring, substitute);
                        flag = true;
                    }
                    if(!flag){
                        System.out.println("Nothing to replace!");
                    }
                    else {
                        System.out.println(inputPassword);
                    }
                    break;
            }
            commands = scanner.nextLine();
        }
        if(!inputPassword.isEmpty()) {
            System.out.printf("Your password is: %s%n", inputPassword);
        }
    }
}
