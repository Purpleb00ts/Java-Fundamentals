import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Scanner;

public class Orders {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

         String[] product = scanner.nextLine().split(" ");

        LinkedHashMap<String, Double> ordersMap = new LinkedHashMap<>();
        LinkedHashMap<String, Double> rememberOrders = new LinkedHashMap<>();

        while(!product[0].equals("buy")){
            double price = Double.parseDouble(product[1]);

            double quantity = Double.parseDouble(product[2]);

            if(ordersMap.containsKey(product[0])){
                rememberOrders.put(product[0], rememberOrders.get(product[0]) + quantity);
                ordersMap.put(product[0], rememberOrders.get(product[0]) * price);
            }
            else{
                ordersMap.put(product[0], quantity * price);
                rememberOrders.put(product[0], quantity);
            }

            product = scanner.nextLine().split(" ");
        }
        ordersMap.forEach((key, value) -> System.out.printf("%s -> %.2f%n", key, value));
    }
}
