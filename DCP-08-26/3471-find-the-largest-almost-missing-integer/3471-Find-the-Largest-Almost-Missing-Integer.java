class Solution {
    public int largestInteger(int[] nums, int k) {

        int[] freq = new int[51];
        int[] count = new int[51];

        int l = 0;

        for (int r = 0; r < nums.length; r++) {

            freq[nums[r]]++;

            if (r - l + 1 == k) {

                for (int x = 0; x <= 50; x++) {
                    if (freq[x] > 0) {
                        count[x]++;
                    }
                }

                freq[nums[l]]--;

                l++;
            }
        }

        for (int x = 50; x >= 0; x--) {
            if (count[x] == 1) {
                return x;
            }
        }

        return -1;
    }
}