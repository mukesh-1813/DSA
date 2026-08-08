class Solution {
    public int[] validSequence(String word1, String word2) {

        int n = word1.length();
        int m = word2.length();

        int[] suf = new int[n + 1];

        int j = m - 1;

        for (int i = n - 1; i >= 0; i--) {

            if (j >= 0 && word1.charAt(i) == word2.charAt(j)) {
                j--;
            }

            suf[i] = j;
        }

        int[] ans = new int[m];

        int i = 0;
        j = 0;
        int k = 0;

        boolean mismatchUsed = false;

        while (i < n && j < m) {
            if (word1.charAt(i) == word2.charAt(j)) {

                ans[k++] = i;

                i++;
                j++;
            }

            else if (!mismatchUsed) {
                if (i + 1 <= n && suf[i + 1] <= j) {

                    ans[k++] = i;

                    mismatchUsed = true;

                    i++;
                    j++;
                }
                else {
                    i++;
                }
            }

            // Already used mismatch, so cannot take this character
            else {
                i++;
            }
        }

        // Couldn't construct a valid sequence
        if (k != m) {
            return new int[0];
        }

        return ans;
    }
}