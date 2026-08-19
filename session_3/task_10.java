import java.util.Scanner;

public class task_10 {
    final static double DISCOUNT = 0.10;

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        System.out.print("Enter price of item 1: ");
        double item1 = scn.nextDouble();

        System.out.print("Enter price of item 2: ");
        double item2 = scn.nextDouble();

        System.out.print("Enter price of item 3: ");
        double item3 = scn.nextDouble();

        double total = item1 + item2 + item3;
        double discountAmount = total * DISCOUNT;
        double finalAmount = total - discountAmount;

        System.out.println("Total = " + total);
        System.out.println("Discount = " + discountAmount);
        System.out.println("Final Amount = " + finalAmount);

        scn.close();
    }
}
