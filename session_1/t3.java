import java.util.Scanner;

public class t3 {
    public static void main (String[] args){
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter first number: ");
        int n1 = scanner.nextInt();

        System.out.print("Enter second number: ");
        int n2 = scanner.nextInt();

        System.out.print("Enter third number: ");
        int n3 = scanner.nextInt();

        if (n1 >= n2) {
            if (n1 >= n3) {
                System.out.println("largest number is " + n1);
            }
            else {
                System.out.println("largest number is " + n3);
            }
        } else {
            if (n2 >= n3) {
                System.out.println("largest is "+ n2);
            }
            else {
                System.out.println("largest is " + n3);
            }
        }
    }
}