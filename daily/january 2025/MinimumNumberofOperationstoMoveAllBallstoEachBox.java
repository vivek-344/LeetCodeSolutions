// January 6th, 2025
// 1769. Minimum Number of Operations to Move All Balls to Each Box
// https://leetcode.com/problems/minimum-number-of-operations-to-move-all-balls-to-each-box/

public class MinimumNumberofOperationstoMoveAllBallstoEachBox {
    public int[] minOperations(String boxes) {
        int n = boxes.length();
        int[] ans = new int[n];
        char[] arr = boxes.toCharArray();
        int[] fd = new int[n];
        int[] bd = new int[n];

        int count = 0;
        for (int i = 0; i < n; i++) {
            if (i > 0) {
                fd[i] = fd[i - 1] + count;
            }
            count += arr[i] - '0';
        }

        count = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (i < n - 1) {
                bd[i] = bd[i + 1] + count;
            }
            count += arr[i] - '0';
        }

        for (int i = 0; i < n; i++) {
            ans[i] = fd[i] + bd[i];
        }

        return ans;
    }
}
