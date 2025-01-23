// January 23rd, 2025
// 1267. Count Servers that Communicate
// https://leetcode.com/problems/count-servers-that-communicate/description/

public class CountServersthatCommunicate {
    public int countServers(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int ti = 0, tj = 0, count = 0;
        boolean[][] visited = new boolean[m][n];
        for(int i = 0; i < m; i++) {
            boolean hasServer = false;
            boolean canCommunicate = false;
            for(int j = 0; j < n; j++) {
                if (!hasServer && grid[i][j] == 1) {
                    hasServer = true;
                    if (visited[i][j] == false) {
                        count++;
                        visited[i][j] = true;
                    }
                    ti = i;
                    tj = j;
                }
                else if (hasServer && !canCommunicate && grid[i][j] == 1) {
                    canCommunicate = true;
                    if (visited[i][j] == false) {
                        count++;
                        visited[i][j] = true;
                    }
                }
                else if (hasServer && canCommunicate && grid[i][j] == 1) {
                    if (visited[i][j] == false) {
                        count++;
                        visited[i][j] = true;
                    }
                }
            }
            if (hasServer && !canCommunicate) {
                visited[ti][tj] = false;
                count--;
            }
        }
        for(int j = 0; j < n; j++) {
            boolean hasServer = false;
            boolean canCommunicate = false;
            boolean oldValue = false;
            for(int i = 0; i < m; i++) {
                if (!hasServer && grid[i][j] == 1) {
                    hasServer = true;
                    if (visited[i][j] == false) {
                        count++;
                        visited[i][j] = true;
                    } else {
                        oldValue = true;
                    }
                    ti = i;
                    tj = j;
                }
                else if (hasServer && !canCommunicate && grid[i][j] == 1) {
                    canCommunicate = true;
                    if (visited[i][j] == false) {
                        count++;
                        visited[i][j] = true;
                    }
                }
                else if (hasServer && canCommunicate && grid[i][j] == 1) {
                    if (visited[i][j] == false) {
                        count++;
                        visited[i][j] = true;
                    }
                }
            }
            if (!oldValue && hasServer && !canCommunicate) {
                visited[ti][tj] = false;
                count--;
            }
        }
        return count;
    }
}
