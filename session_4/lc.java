import java.util.Arrays;

public class lc{
    public static void main(String[] s){
    	int [] nums1 = {1,2,4,5,7};
	int [] nums2 = {3,6,8};
	
	solution(nums1, nums2);
    }

    static void solution(int[] nums1, int[] nums2){
    	int i = 0;
	int j = 0;
	int k = 0;

	int [] arr = new int [nums1.length + nums2.length];
	while (i < nums1.length && j < nums2.length){
	    if (nums1[i] <= nums2[j]){
	    	arr[k] = nums1[i];
		k ++;
		i ++;
	    }
	    else {
	    	arr[k] = nums2[j];
		k ++;
		j ++;
	    }
	}

	System.out.println(Arrays.toString(arr));
    }
}
