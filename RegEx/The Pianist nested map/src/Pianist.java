import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Pianist {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        LinkedHashMap<String, LinkedHashMap<String, String>> pianists = new LinkedHashMap<>();


        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split("\\|");

            boolean flag1 = true;

            if (!pianists.containsKey(input[1])) {
                for (Map.Entry<String, LinkedHashMap<String, String>> entry : pianists.entrySet()) {
                    if(entry.getValue().containsKey(input[0])) {
                        flag1 = false;
                        break;
                    }
                }
                if(flag1) {
                    pianists.put(input[1], new LinkedHashMap<>());
                    pianists.get(input[1]).put(input[0], input[2]);
                }
            } else {
                for (Map.Entry<String, LinkedHashMap<String, String>> entry : pianists.entrySet()) {
                    if(entry.getValue().containsKey(input[0])) {
                        flag1 = false;
                        break;
                    }
                }
                    if (flag1) {
                        pianists.get(input[1]).put(input[0], input[2]);
                    }
                }
            }

        String commands = scanner.nextLine();

        while (!commands.equals("Stop")) {
            String[] command = commands.split("\\|");


            switch (command[0]) {
                case "Add":
                    String composer = command[2];

                    String piece = command[1];

                    String key = command[3];

                    boolean flag = true;

                    for (Map.Entry<String, LinkedHashMap<String, String>> entry : pianists.entrySet()) {
                        if(entry.getValue().containsKey(piece)){
                            flag = false;
                            break;
                        }
                    }
                    if (flag) {
                        if (!pianists.containsKey(composer)) {
                            pianists.put(composer, new LinkedHashMap<>());
                            pianists.get(composer).put(piece, key);
                            System.out.printf("%s by %s in %s added to the collection!%n", piece, composer, key);
                        } else if (pianists.containsKey(composer) && !pianists.get(composer).containsKey(piece)) {
                            pianists.get(composer).put(piece, key);
                            System.out.printf("%s by %s in %s added to the collection!%n", piece, composer, key);
                        } else {
                            System.out.printf("%s is already in the collection!%n", piece);
                        }
                    } else {
                        System.out.printf("%s is already in the collection!%n", piece);
                    }
                    break;
                case "Remove":
                    String pieceToRemove = command[1];

                    boolean removed = false;

                    for (Map.Entry<String, LinkedHashMap<String, String>> entry : pianists.entrySet()) {
                        if (entry.getValue().containsKey(pieceToRemove)) {
                            entry.getValue().remove(pieceToRemove);
                            System.out.printf("Successfully removed %s!%n", pieceToRemove);
                            removed = true;
                        }
                    }
                    if (!removed) {
                        System.out.printf("Invalid operation! %s does not exist in the collection.%n", pieceToRemove);
                    }
                    break;
                case "ChangeKey":
                    String pieceToChange = command[1];

                    String keyToChange = command[2];

                    boolean changed = false;

                    for (Map.Entry<String, LinkedHashMap<String, String>> entry : pianists.entrySet()) {
                        if (entry.getValue().containsKey(pieceToChange)) {
                            entry.getValue().put(pieceToChange, keyToChange);
                            System.out.printf("Changed the key of %s to %s!%n", pieceToChange, keyToChange);
                            changed = true;
                        }
                    }
                    if (!changed) {
                        System.out.printf("Invalid operation! %s does not exist in the collection.%n", pieceToChange);
                    }
                    break;
            }
            commands = scanner.nextLine();
        }

        for (Map.Entry<String, LinkedHashMap<String, String>> entry : pianists.entrySet()) {
            for (Map.Entry<String, String> piece : entry.getValue().entrySet()) {
                System.out.printf("%s -> Composer: %s, Key: %s%n", piece.getKey(), entry.getKey(), piece.getValue());
            }
        }
    }
}

