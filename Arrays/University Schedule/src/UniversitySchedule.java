import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class UniversitySchedule {
    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);

        String input = scanner.nextLine();

        List<String> lessons = Arrays.stream(input.split(", "))
                .collect(Collectors.toList());

        String commands = scanner.nextLine();

        while(!commands.equals("course start"))
        {
            String[] command = commands.split(":");

            if(command[0].equals("Add") && !lessons.contains(command [1])){
                lessons.add(command[1]);
            }

            else if(command[0].equals("Remove")){
                lessons.remove(command[1]);
            }

            else if(command[0].equals("Insert") && !lessons.contains(command [1])){
                lessons.add(Integer.parseInt(command[2]), command[1]);
            }

            else if(command[0].equals("Swap") && lessons.contains(command [1]) && lessons.contains(command [2])){
                if(lessons.contains(command[1]) && lessons.contains(command[2])){
                    Collections.swap(lessons, lessons.indexOf(command[1]), lessons.indexOf(command[2]));
                    if(lessons.contains(command [1] + "-Exercise") || lessons.contains(command [2] + "-Exercise")){


                        if(lessons.contains(command [1] + "-Exercise")) {
                            lessons.remove(command [1] + "-Exercise");
                            lessons.add(lessons.indexOf(command[1]) + 1, command[1] + "-Exercise");
                        }
                        if(lessons.contains(command [2] + "-Exercise")) {
                            lessons.remove(command [2] + "-Exercise");
                            lessons.add(lessons.indexOf(command[2]) + 1, command[2] + "-Exercise");
                        }
                    }
                }
            }

            else if(command[0].equals("Exercise") && !lessons.contains(command [1] + "-Exercise")){
                if(!lessons.contains(command [1])){
                    lessons.add(command[1]);
                    lessons.add(command[1] + "-Exercise");
                }
                else{
                    lessons.add(lessons.indexOf(command[1]) + 1, command[1] + "-Exercise");
                }
            }
            commands = scanner.nextLine();
        }
        for (int i = 0 ; i < lessons.size(); i++) {
            System.out.printf("%d.%s%n", i + 1, lessons.get(i));
        }
    }
}
