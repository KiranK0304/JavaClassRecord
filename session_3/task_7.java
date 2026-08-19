import java.util.Scanner;

public class task_7 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        System.out.print("Enter temperature in Celsius: ");
        double celsius = scn.nextDouble();

        double fahrenheit = (celsius * 9.0 / 5.0) + 32;
        System.out.println("Fahrenheit = " + fahrenheit);

        scn.close();
    }
}
