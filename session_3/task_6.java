import java.util.Scanner;

public class task_6 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        System.out.print("Enter current year: ");
        int currentYear = scn.nextInt();

        System.out.print("Enter birth year: ");
        int birthYear = scn.nextInt();

        int age = currentYear - birthYear;
        System.out.println("Age = " + age);

        scn.close();
    }
}
