class Solution {
    public int minPatches(int[] nums, int n) {
        int minPatches = 0;
        long miss = 1;
        int i = 0;

        while (miss <= n) {
            if (i < nums.length && nums[i] <= miss) {
                miss += nums[i];
                i++;
            } else {
                miss += miss;
                minPatches++;
            }
        }

        return minPatches;
    }
}

public class Problem1 {
    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] nums1 = { 1, 3 };
        int n1 = 6;
        int result1 = solution.minPatches(nums1, n1);
        System.out.println(result1);

        int[] nums2 = { 1, 5, 10 };
        int n2 = 20;
        int result2 = solution.minPatches(nums2, n2);
        System.out.println(result2);

        int[] nums3 = { 1, 2, 2 };
        int n3 = 5;
        int result3 = solution.minPatches(nums3, n3);
        System.out.println(result3);
    }
}
