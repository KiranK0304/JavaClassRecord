import java.util.Arrays;

public class test {
    public static void main(String[] s) {
        int[] list = {1, 2, 4, 5, 7};
        int[] nums2 = {3, 6, 8};

        int len = nums2.length + list.length;
        int[] combined = Arrays.copyOf(list, len);

        System.arraycopy(nums2, 0, combined, list.length, nums2.length);
        Arrays.sort(combined);

        System.out.println("Combined and sorted array: " + Arrays.toString(combined));
    }
}
