class Solution {
    public int longestPalindromeSubseq(String s) {
        String str = new StringBuilder(s).reverse().toString();

        int n=s.length();
        int m=str.length();
        return lcs(s,str);

    }
    public int lcs(String t1, String t2){
        int n=t1.length();
        int m=t2.length();

        int[][] dp= new int[n+1][m+1];

        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if(t1.charAt(i-1)==t2.charAt(j-1)){
                    dp[i][j]=1+dp[i-1][j-1];
                }else{
                    int case1=dp[i-1][j];
                    int case2=dp[i][j-1];
                    dp[i][j]=Math.max(case1,case2);
                }
            }
        }
        return dp[n][m];
    }
}