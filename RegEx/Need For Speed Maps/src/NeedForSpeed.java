import java.util.*;

public class NeedForSpeed {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        LinkedHashMap<String, List<Integer>> cars = new LinkedHashMap<>();

        for (int i = 0; i < n; i++) {
            String[] inputCars = scanner.nextLine().split("\\|");

            cars.put(inputCars[0], new ArrayList<>());

            cars.get(inputCars[0]).add(Integer.parseInt(inputCars[1]));
            cars.get(inputCars[0]).add(Integer.parseInt(inputCars[2]));
        }

        String commands = scanner.nextLine();

        while(!commands.equals("Stop")){
            String[] command = commands.split(" : ");

            switch (command[0]){
                case "Drive":
                    String car = command[1];
                    int distance = Integer.parseInt(command[2]);
                    int fuel = Integer.parseInt(command[3]);

                    if(fuel < cars.get(car).get(1)){
                        cars.get(car).set(0, cars.get(car).get(0) + distance);
                        cars.get(car).set(1, cars.get(car).get(1) - fuel);
                        System.out.printf("%s driven for %d kilometers. %d liters of fuel consumed.%n", car, distance, fuel);
                    }
                    else {
                        System.out.println("Not enough fuel to make that ride");
                    }
                    if(cars.get(car).get(0) >= 100000){
                        cars.remove(car);
                        System.out.printf("Time to sell the %s!%n", car);
                    }
                    break;
                case "Refuel":
                    String carToRefill = command[1];
                    int fuelToRefill = Integer.parseInt(command[2]);
                    if(cars.get(carToRefill).get(1) + fuelToRefill <= 75) {
                        cars.get(carToRefill).set(1, cars.get(carToRefill).get(1) + fuelToRefill);
                        System.out.printf("%s refueled with %d liters%n", carToRefill, fuelToRefill);
                    } else {
                        System.out.printf("%s refueled with %d liters%n", carToRefill, 75 - cars.get(carToRefill).get(1));
                        cars.get(carToRefill).set(1, 75);
                    }
                    break;
                case "Revert":
                    String carToRevert = command[1];
                    int distanceToRevert = Integer.parseInt(command[2]);
                    if(cars.get(carToRevert).get(0) - distanceToRevert <= 10000){
                        cars.get(carToRevert).set(0, 10000);
                    }
                    else {
                        cars.get(carToRevert).set(0, cars.get(carToRevert).get(0) - distanceToRevert);
                        System.out.printf("%s mileage decreased by %d kilometers%n", carToRevert, distanceToRevert);
                    }
            }
            commands = scanner.nextLine();
        }

        for (Map.Entry<String, List<Integer>> entry : cars.entrySet()) {
            System.out.printf("%s -> Mileage: %d kms, Fuel in the tank: %d lt.%n", entry.getKey(), entry.getValue().get(0), entry.getValue().get(1));
        }
    }
}
