import java.util.Scanner;
import java.util.Arrays;

public class task6{
    static Scanner scn = new Scanner(System.in);

    public static void main (){
        System.out.print("enter the number of values that you want to add: ");
        int num = scn.nextInt();
        int [] nums = create_arr(num);
        // finding the max value
        int bgst = max(nums);
        System.out.println(bgst);
    }

    static int[] create_arr(int len){

        int [] arr = new int[len];
        for (int i = 0; i<len; i++) {
            System.out.print("enter value " + i+1 + ": ");
            int val = scn.nextInt();
            arr[i] = val;
        }
//        System.out.println(Arrays.toString(arr));
        return arr;
    }

    static int max(int [] nums) {
        int max = nums[0];
        for (int i: nums) {
            if (i > max) {
                max = i;
            }
        }
        return max;
    }
}