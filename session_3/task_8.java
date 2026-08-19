import java.util.Scanner;

public class task_8 {
    final static double DEFAULT_RATE = 5.0;

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        System.out.print("Principal amount: ");
        double principal = scn.nextDouble();
        scn.nextLine();

        System.out.print("Rate of interest (press Enter for default 5.0): ");
        String rateInput = scn.nextLine().trim();
        double rate = rateInput.isEmpty() ? DEFAULT_RATE : Double.parseDouble(rateInput);

        System.out.print("Time: ");
        double time = scn.nextDouble();

        double interest = (principal * rate * time) / 100;
        System.out.println("Interest = " + interest);

        scn.close();
    }
}
