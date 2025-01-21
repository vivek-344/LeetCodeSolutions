// January 21st, 2025
// 2017. Grid Game
// https://leetcode.com/problems/grid-game/description/

public class GridGame {
    public long gridGame(int[][] grid) {
        int n = grid[0].length;

        long[] topPrefix = new long[n];
        long[] bottomPrefix = new long[n];

        topPrefix[0] = grid[0][0];
        bottomPrefix[0] = grid[1][0];
        for (int i = 1; i < n; i++) {
            topPrefix[i] = topPrefix[i - 1] + grid[0][i];
            bottomPrefix[i] = bottomPrefix[i - 1] + grid[1][i];
        }

        long result = Long.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            long topRemaining = (i == n - 1) ? 0 : topPrefix[n - 1] - topPrefix[i];
            long bottomAccumulated = (i == 0) ? 0 : bottomPrefix[i - 1];

            long secondPlayerScore = Math.max(topRemaining, bottomAccumulated);
            result = Math.min(result, secondPlayerScore);
        }

        return result;
    }
}
