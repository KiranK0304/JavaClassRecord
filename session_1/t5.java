import java.util.Scanner;

public class t5 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.print("enter the number that you want to sum: ");
        int num = scn.nextInt();
        int sum = num * (num + 1) / 2;
        System.out.print("total = " + sum);
    }

}