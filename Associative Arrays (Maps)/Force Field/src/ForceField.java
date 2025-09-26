import java.awt.*;
import java.util.*;
import java.util.List;

public class ForceField {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        String[] input1 = {};

        String[] input2 = {};

        LinkedHashMap<String, ArrayList<String>> force = new LinkedHashMap<>();

        while(!input.equals("Lumpawaroo")){
            if(input.contains(" | ")) {
                input1 = input.split(" \\| ");

                String forceUser = input1[1];

                String forceSide = input1[0];

                if(!force.containsKey(forceSide)){
                    force.put(forceSide, new ArrayList<>());
                }

                 boolean isContain = false;

                for (List<String> list: force.values()){
                    if(list.contains(forceUser)){
                        isContain = true;
                        break;
                    }
                }

                if(!isContain){
                    force.get(forceSide).add(forceUser);
                }
            }

            if(input.contains(" -> ")){
                input2 = input.split(" -> ");

                String forceUser = input1[0];

                String forceSide = input1[1];

                force.entrySet().forEach(entryForce -> entryForce.getValue().remove(forceUser));

                if(!force.containsKey(forceSide)){
                    force.put(forceSide, new ArrayList<>());
                    force.get(force).add(forceUser);
                }
                else{
                    force.get(force).add(forceUser);
                }

                System.out.printf("%s joins the %s side!%n", forceUser, forceSide);
            }
        }
        force.entrySet().stream().filter(e -> e.getValue().size() > 0)
                .forEach(e -> {
                    System.out.printf("Side: %s, Members: %d%n", e.getKey(), e.getValue().size());
                    e.getValue().forEach(user -> System.out.println("! " + user));
                });
    }
}
