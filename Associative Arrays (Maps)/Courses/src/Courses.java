import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Courses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(" : ");

        LinkedHashMap<String, ArrayList<String>> coursesMap = new LinkedHashMap<>();

        while(!input[0].equals("end")){
            String courseName = input[0];

            String studentName = input[1];

            if(coursesMap.containsKey(courseName)){
                coursesMap.get(courseName).add(studentName);
            }
            else{
                coursesMap.put(courseName, new ArrayList<>());
                coursesMap.get(courseName).add(studentName);
            }

            input = scanner.nextLine().split(" : ");
        }

        for (Map.Entry<String, ArrayList<String>> entry : coursesMap.entrySet()) {
            System.out.printf("%s: %d%n", entry.getKey(), entry.getValue().size());
            entry.getValue().stream().
                    forEach(e -> System.out.printf("-- %s%n", e));
        }
    }
}
