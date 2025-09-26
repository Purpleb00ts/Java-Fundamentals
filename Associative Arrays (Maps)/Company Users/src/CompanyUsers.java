import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.function.DoubleFunction;
import java.util.stream.Collectors;

public class CompanyUsers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(" -> ");

        LinkedHashMap<String, ArrayList<String>> companyUsers = new LinkedHashMap<>();

        while(!input[0].equals("End")){
            String company = input[0];

            String ID = input[1];

            if(companyUsers.containsKey(company)){
                if(!companyUsers.get(company).contains(ID)) {
                    companyUsers.get(company).add(ID);
                }
            }
            else{
                companyUsers.put(company, new ArrayList<>());
                companyUsers.get(company).add(ID);
            }

            input = scanner.nextLine().split(" -> ");
        }

        for (Map.Entry<String, ArrayList<String>> entry : companyUsers.entrySet()) {
            System.out.printf("%s%n", entry.getKey());
            entry.getValue().stream().
                    forEach(e -> System.out.printf("-- %s%n", e));
        }
    }
}
