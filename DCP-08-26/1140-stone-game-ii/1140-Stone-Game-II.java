import java.util.Arrays;

class Solution {

    int[] suffix;
    int[][] dp;

    public int stoneGameII(int[] piles) {

        int n = piles.length;

        suffix = new int[n + 1];

        for (int i = n - 1; i >= 0; i--) {
            suffix[i] = suffix[i + 1] + piles[i];
        }

        dp = new int[n + 1][n + 1];

        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return solve(piles, 0, 1);
    }

    private int solve(int[] piles, int i, int m) {

        int n = piles.length;

        if (i >= n) {
            return 0;
        }

        if (i + 2 * m >= n) {
            return suffix[i];
        }

        if (dp[i][m] != -1) {
            return dp[i][m];
        }

        int rem = suffix[i];
        int ans = 0;

        for (int x = 1; x <= 2 * m && i + x <= n; x++) {

            int newM = Math.max(m, x);

            int opponent = solve(piles, i + x, newM);

            int currentPlayer = rem - opponent;

            ans = Math.max(ans, currentPlayer);
        }

        return dp[i][m] = ans;
    }
}