import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Pianist2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        LinkedHashMap<String, ArrayList<String>> pieces = new LinkedHashMap<>();

        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split("\\|");

            if(!pieces.containsKey(input[0])){
                pieces.put(input[0], new ArrayList<>());
                pieces.get(input[0]).add(input[1]);
                pieces.get(input[0]).add(input[2]);
            }
            else {
                pieces.get(input[0]).add(input[1]);
                pieces.get(input[0]).add(input[2]);
            }
        }

        String commands = scanner.nextLine();

        while(!commands.equals("Stop")){
            String[] command = commands.split("\\|");

            switch (command[0]){
                case "Add":
                    String piece = command[1];
                    String composer = command[2];
                    String key = command[3];

                    if(!pieces.containsKey(piece)){
                        pieces.put(piece, new ArrayList<>());
                        pieces.get(piece).add(composer);
                        pieces.get(piece).add(key);
                        System.out.printf("%s by %s in %s added to the collection!%n", piece, composer, key);
                    } else {
                        System.out.printf("%s is already in the collection!%n", piece);
                    }
                    break;
                case "Remove":
                    String pieceToRemove = command[1];

                    if(pieces.containsKey(pieceToRemove)){
                        pieces.remove(pieceToRemove);
                        System.out.printf("Successfully removed %s!%n", pieceToRemove);
                    }else{
                        System.out.printf("Invalid operation! %s does not exist in the collection.%n", pieceToRemove);
                    }
                    break;
                case "ChangeKey":
                    String pieceToChange = command[1];
                    String keyToChange = command[2];

                    if(pieces.containsKey(pieceToChange)){
                        pieces.get(pieceToChange).remove(1);
                        pieces.get(pieceToChange).add(keyToChange);
                        System.out.printf("Changed the key of %s to %s!%n", pieceToChange, keyToChange);
                    } else {
                        System.out.printf("Invalid operation! %s does not exist in the collection.%n", pieceToChange);
                    }
                    break;
            }
            commands = scanner.nextLine();
        }
        for (Map.Entry<String, ArrayList<String>> entry : pieces.entrySet()) {
            System.out.printf("%s -> Composer: %s, Key: %s%n", entry.getKey(), entry.getValue().get(0), entry.getValue().get(1));
        }
    }
}
