class Solution {
    public int minEatingSpeed(int[] piles, int h) {

        int low = 1;
        int max = -1;

        for (int i = 0; i < piles.length; i++) {
            max = Math.max(max, piles[i]);
        }

        int high = max;
        int ans = 0;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            long hours = find(piles, mid);

            if (hours <= h) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return ans;
    }

    private long find(int[] arr, int speed) {

        long sum = 0;

        for (int i = 0; i < arr.length; i++) {
            sum += (arr[i] + (long)speed - 1) / speed;
        }

        return sum;
    }
}