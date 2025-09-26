import java.util.Scanner;

public class SecretChat {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        StringBuilder input = new StringBuilder();

        input.append(scanner.nextLine());

        String commands = scanner.nextLine();

        while(!commands.equals("Reveal")){
            String[] command = commands.split(":\\|:");

            switch(command[0]){
                case "InsertSpace":
                    int index = Integer.parseInt(command[1]);
                    input.insert(index, " ");
                    System.out.println(input);
                    break;
                case "Reverse":
                    StringBuilder toReverse = new StringBuilder();
                    toReverse.append(command[1]);
                    toReverse.reverse();
                    if(input.toString().contains(command[1])){
                        input.append(toReverse);
                        input.replace(input.indexOf(command[1]), input.indexOf(command[1]) + command[1].length(), "");
                        System.out.println(input);
                    }
                    else{
                        System.out.println("error");
                    }

                    break;
                case "ChangeAll":
                    String substring = command[1];
                    String substitute = command[2];
                    while(input.toString().contains(substring)){
                        input.replace(input.indexOf(substring), input.indexOf(substring) + substring.length(), substitute);
                    }
                    System.out.println(input);
                    break;
            }
            commands = scanner.nextLine();
        }
        System.out.printf("You have a new text message: %s%n", input);
    }
}
