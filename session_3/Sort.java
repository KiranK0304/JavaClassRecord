import java.util.Arrays;

public class Sort{
    public static void main(String[] args){
        int[] list = {100, 8,2,3,9,4,1,7};
        int len = list.length - 1;
        quick_sort(list,0, len);
        System.out.println(Arrays.toString(list));

    }

    public static void quick_sort(int[] arr, int left, int right) {
        if (left < right) {
            int p = partition(arr, left, right);
            quick_sort(arr, left, p-1);
            quick_sort(arr, p+1, right);
        }
    }

    public static int partition(int[] arr, int left, int right) {
        int pivot = arr[right];
        int i = left - 1;

        for (int j = left; j <= right; j ++ ) {
            if (arr[j] < pivot) {
                i += 1;
                swap(arr, i, j);
            }
        }
        i += 1;
        swap(arr, i, right);
        return i;
    }

    public static void swap(int[]arr, int l, int r) {
        int temp = arr[l];
        arr[l] = arr[r];
        arr[r] = temp;
    }
}