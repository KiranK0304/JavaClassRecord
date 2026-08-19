import java.util.Scanner;

public class t4 {
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        System.out.print("Enter the number: ");
        int num = scn.nextInt();

        for (int i=1; i <=10; i++){
            System.out.println(i + " * " + num + " = " + i*num);
        }
    }
}