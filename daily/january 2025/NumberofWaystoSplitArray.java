// December 3rd, 2025
// 2270. Number of Ways to Split Array
// https://leetcode.com/problems/number-of-ways-to-split-array/

public class NumberofWaystoSplitArray {
    // Optimized Version
    public int waysToSplitArray(int[] nums) {
        int n = nums.length, count = 0;
        long sum = 0, total = 0;

        for (int num : nums) {
            total += num;
        }

        for (int i = 0; i < n - 1; i++) {
            sum += nums[i];
            if (sum >= total - sum) {
                count++;
            }
        }

        return count;
    }
}

/*
public int waysToSplitArray(int[] nums) {
    int n = nums.length, count = 0;
    long sum = 0;
    long[] arr = new long[n];
    for(int i = 0; i < n; i++) {
        sum += nums[i];
        arr[i] = sum;
    }
    sum = 0;
    for(int i = n-1; i > 0; i--) {
        sum += nums[i];
        if (sum <= arr[i-1]) count++;
    }
    return count;
}
 */
