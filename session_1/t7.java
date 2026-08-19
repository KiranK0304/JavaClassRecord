import java.util.Scanner;

public class t7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // String operations demonstration
        System.out.print("Enter a string: ");
        String str = scanner.nextLine();

        System.out.println("Uppercase: " + str.toUpperCase());
        System.out.println("Length: " + str.length());

        // Palindrome check
        String reversed = new StringBuilder(str).reverse().toString();
        if (str.equalsIgnoreCase(reversed)) {
            System.out.println("\"" + str + "\" is a palindrome.");
        } else {
            System.out.println("\"" + str + "\" is not a palindrome.");
        }

        // Array operations demonstration
        int[] numbers = {12, 45, 7, 89, 23, 56};
        System.out.print("Array elements: ");
        int max = numbers[0];
        int sum = 0;
        for (int num : numbers) {
            System.out.print(num + " ");
            if (num > max) {
                max = num;
            }
            sum += num;
        }
        System.out.println("\nMaximum element: " + max);
        System.out.println("Average: " + ((double) sum / numbers.length));

        scanner.close();
    }
}
