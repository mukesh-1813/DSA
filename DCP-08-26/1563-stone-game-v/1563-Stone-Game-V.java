class Solution {

    public int stoneGameV(int[] stoneValue) {

        int n = stoneValue.length;

        // Prefix Sum
        int[] prefix = new int[n + 1];

        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + stoneValue[i];
        }

        // dp[l][r] = maximum score from [l, r)
        int[][] dp = new int[n][n + 1];

        for (int len = 2; len <= n; len++) {

            for (int l = 0; l + len <= n; l++) {

                int end = l + len;

                int ans = 0;

                for (int mid = l + 1; mid < end; mid++) {

                    int left = prefix[mid] - prefix[l];
                    int right = prefix[end] - prefix[mid];

                    if (left < right) {

                        ans = Math.max(
                            ans,
                            left + dp[l][mid]
                        );

                    } 
                    else if (right < left) {

                        ans = Math.max(
                            ans,
                            right + dp[mid][end]
                        );

                    } 
                    else {

                        ans = Math.max(
                            ans,
                            Math.max(
                                left + dp[l][mid],
                                right + dp[mid][end]
                            )
                        );
                    }
                }

                dp[l][end] = ans;
            }
        }

        return dp[0][n];
    }
}