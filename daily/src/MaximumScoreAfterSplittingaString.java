// January 1st, 2025
// 1422. Maximum Score After Splitting a String
// https://leetcode.com/problems/maximum-score-after-splitting-a-string/
public class MaximumScoreAfterSplittingaString {
    public int maxScore(String s) {
        int total_one = 0, n = s.length();
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '1') {
                total_one++;
            }
        }

        int max = Integer.MIN_VALUE;
        int curr_zero = 0, curr_one = total_one;

        for (int i = 0; i < n - 1; i++) {
            if (s.charAt(i) == '0') {
                curr_zero++;
            } else {
                curr_one--;
            }
            max = Math.max(max, curr_zero + curr_one);
        }

        return max;
    }
}