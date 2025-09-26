import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Resources {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String resource = scanner.nextLine();

        LinkedHashMap<String, Integer> resourceMap = new LinkedHashMap<>();

        while(!resource.equals("stop")){

            int quantity = Integer.parseInt(scanner.nextLine());

            if(resourceMap.containsKey(resource)){
                resourceMap.put(resource, resourceMap.get(resource) + quantity);
            }
            else{
                resourceMap.put(resource, quantity);
            }

            resource = scanner.nextLine();
        }

        for (Map.Entry<String, Integer> entry : resourceMap.entrySet()) {
            System.out.printf("%s -> %d%n", entry.getKey(), entry.getValue());
        }
    }
}
