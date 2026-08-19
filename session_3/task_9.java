import java.util.Scanner;

public class task_9 {
    final static double DATA_LIMIT = 30.0;

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        System.out.print("Enter data used in GB: ");
        double usedData = scn.nextDouble();

        double remainingData = DATA_LIMIT - usedData;
        System.out.println("Used: " + usedData + " GB");
        System.out.println("Remaining: " + remainingData + " GB");

        scn.close();
    }
}
