class Solution {
    public int maximumGap(String skill, String station) {
        int n = skill.length();
        int m = station.length();

        if (n == 1) {
            return 0;
        }

        int[] left = new int[n];
        int[] right = new int[n];
        int prev = -1;

        for (int i = 0; i < n; i++) {

            int j = prev + 1;

            while (station.charAt(j) != skill.charAt(i)) {
                j++;
            }

            left[i] = j;
            prev = j;
        }

            prev = m;

        for (int i = n - 1; i >= 0; i--) {

            int j = prev - 1;

            while (station.charAt(j) != skill.charAt(i)) {
                j--;
            }

            right[i] = j;
            prev = j;
        }

          
        int ans = 0;

        for (int i = 1; i < n; i++) {
            ans = Math.max(ans, right[i] - left[i - 1]);
        }

        return ans;
    }
}