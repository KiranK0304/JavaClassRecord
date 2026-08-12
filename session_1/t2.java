import java.util.Scanner;

public class t2 {
    public static void main (String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("enter the number: ");
        int num = scanner.nextInt();
        if (num % 2 == 0) {
            System.out.println(num +" is even");
        } else {
            System.out.println(num + " is odd");
        }

    }
}