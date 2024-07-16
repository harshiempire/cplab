import java.util.*;

public class LongestIncPath {
    private int[] dx = new int[] { 0, 0, -1, 1 };
    private int[] dy = new int[] { 1, -1, 0, 0 };

    public int longestIncreasingPath(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return 0;
        }
        int longest = 0;
        int m = matrix.length;
        int n = matrix[0].length;
        // longest path starting from position (i,j)
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                longest = Math.max(longest, dfs(i, j, matrix, dp));
            }
        }
        return longest;
    }

    private int dfs(int row, int col, int[][] matrix, int[][] dp) {
        if (dp[row][col] > 0) {
            return dp[row][col];
        }
        int m = matrix.length;
        int n = matrix[0].length;
        int currentLongest = 0;
        for (int c = 0; c < 4; c++) {
            int i = row + dx[c];
            int j = col + dy[c];
            if (i >= 0 && i < m && j >= 0 && j < n && matrix[row][col] < matrix[i][j]) {
                currentLongest = Math.max(currentLongest, dfs(i, j, matrix, dp));
            }
        }
        dp[row][col] = 1 + currentLongest;
        return dp[row][col];
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int matrix[][] = new int[m][n];
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                matrix[i][j] = sc.nextInt();
        System.out.println(new LongestIncPath().longestIncreasingPath(matrix));
    }
}