import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Legendary {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);



        LinkedHashMap<String, Integer> keyMaterials = new LinkedHashMap<>();

        LinkedHashMap<String, Integer> junkMap = new LinkedHashMap<>();

        keyMaterials.put("shards", 0);
        keyMaterials.put("fragments", 0);
        keyMaterials.put("motes", 0);

        boolean isWin = false;

        while(!isWin){
            String input = scanner.nextLine();

            String[] inputData = input.split("\\s+");

            for(int i = 0; i <= inputData.length - 1; i+= 2){
            String material = inputData[i + 1].toLowerCase();
            int amount = Integer.parseInt(inputData[i]);

            switch(material){
                case "shards":
                    if(keyMaterials.containsKey(material)){
                        keyMaterials.put(material, keyMaterials.get(material) + amount);
                    }
                    else{
                        keyMaterials.put(material, amount);
                    }
                    break;
                case "fragments":
                    if(keyMaterials.containsKey(material)){
                        keyMaterials.put(material, keyMaterials.get(material) + amount);
                    }
                    else{
                        keyMaterials.put(material, amount);
                    }
                    break;
                case "motes":
                    if(keyMaterials.containsKey(material)){
                        keyMaterials.put(material, keyMaterials.get(material) + amount);
                    }
                    else{
                        keyMaterials.put(material, amount);
                    }
                    break;
                default:
                    if(junkMap.containsKey(material)){
                       junkMap.put(material, junkMap.get(material) + amount);
                    }
                    else{
                        junkMap.put(material, amount);
                    }
            }
            for (Map.Entry<String, Integer> entry : keyMaterials.entrySet()) {
                if (entry.getValue() >= 250) {
                    if (entry.getKey().equals("shards")) {
                        keyMaterials.put("shards", keyMaterials.get("shards") - 250);
                        System.out.printf("Shadowmourne obtained!%n");
                        isWin = true;
                        break;
                    }
                    if (entry.getKey().equals("fragments")) {
                        keyMaterials.put("fragments", keyMaterials.get("fragments") - 250);
                        System.out.printf("Valanyr obtained!%n");
                        isWin = true;
                        break;
                    }
                    if (entry.getKey().equals("motes")) {
                        keyMaterials.put("motes", keyMaterials.get("motes") - 250);
                        System.out.printf("Dragonwrath obtained!%n");
                        isWin = true;
                        break;
                    }
                }
            }
                if(isWin){
                    break;
                }
            }
            if(isWin){
                break;
            }
        }

        keyMaterials.forEach((key, value) -> System.out.printf("%s: %d%n", key, value));
        junkMap.forEach(((key, value) -> System.out.printf("%s: %d%n", key, value)));
    }
}
