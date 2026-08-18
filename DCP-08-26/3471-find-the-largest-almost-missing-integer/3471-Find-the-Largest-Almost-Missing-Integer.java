class Solution {

    public int largestInteger(int[] nums, int k) {

        HashMap<Integer, Integer> main = new HashMap<>();
        HashMap<Integer, Integer> map = new HashMap<>();

        int l = 0;
        int max = -1;
        int n = nums.length;

        for (int i = 0; i < n; i++) {

            // Add element to current window
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);

            // Window size == k
            if (i - l + 1 == k) {

                // Every distinct element appears in this window
                for (int ele : map.keySet()) {
                    main.put(ele, main.getOrDefault(ele, 0) + 1);
                }

                // Remove left element
                int x = nums[l];

                map.put(x, map.get(x) - 1);

                if (map.get(x) == 0) {
                    map.remove(x);
                }

                l++;
            }
        }

        // Find largest element present in exactly one window
        for (int ele : main.keySet()) {
            if (main.get(ele) == 1) {
                max = Math.max(max, ele);
            }
        }

        return max;
    }
}