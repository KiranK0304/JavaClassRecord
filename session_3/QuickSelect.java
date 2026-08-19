public class QuickSelect{
    public static void main(String[] args){
        int [] arr = {5,3,6,0,2,1,};
        int val = 2;
        int res = quick_select(arr, 0, arr.length-1, val);
        System.out.println(res);
    }

    static int quick_select(int[] arr, int left, int right, int target) {
        if (left >= right) {
            return arr[left];
        }
        int partition = partition(arr, left, right);
        if (partition == target) {
            return arr[partition];
        }
        else if (partition > target) {
            return quick_select(arr, left, partition-1, target);
        }
        else {
            return quick_select(arr, partition+1, right, target);
        }
    }

    static int partition(int[] arr, int left, int right) {
        int pivot = arr[right];
        int i = left - 1;
        for (int j = left; j < right; j++) {
            if (arr[j] < pivot) {
                i ++;
                swap(arr, i, j);
            }
        }
        i ++;
        swap(arr, i, right);
        return i;
    }

    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}