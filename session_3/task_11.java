import java.util.Scanner;

public class task_11 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        System.out.print("Enter distance in km: ");
        double distance = scn.nextDouble();

        System.out.print("Enter mileage (km/litre): ");
        double mileage = scn.nextDouble();

        System.out.print("Enter petrol price: ");
        double petrolPrice = scn.nextDouble();

        double fuelNeeded = distance / mileage;
        double cost = fuelNeeded * petrolPrice;

        System.out.println("Fuel needed = " + fuelNeeded + " litres");
        System.out.println("Cost = " + cost);

        scn.close();
    }
}
