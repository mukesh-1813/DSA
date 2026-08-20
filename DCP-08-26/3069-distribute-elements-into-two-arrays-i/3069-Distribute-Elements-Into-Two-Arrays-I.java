class Solution {
    public int[] resultArray(int[] nums) {

        int n = nums.length;
        int[] ans = new int[n];

        int p1 = 0;
        int p2 = n - 1;

        ans[p1++] = nums[0];
        ans[p2--] = nums[1];

        for (int i = 2; i < n; i++) {

            int last1 = ans[p1 - 1];
            int last2 = ans[p2 + 1];

            if (last1 > last2) {
                // append to arr1 from front
                ans[p1++] = nums[i];
            } 
            else {
                // append to arr2 from back
                ans[p2--] = nums[i];
            }
        }

        int l = p2 + 1;
        int r = n - 1;

        while (l < r) {
            int temp = ans[l];
            ans[l] = ans[r];
            ans[r] = temp;

            l++;
            r--;
        }

        int start2 = p2 + 1;
        int size2 = n - start2;

        for (int i = 0; i < size2; i++) {
            ans[p1 + i] = ans[start2 + i];
        }

        return ans;
    }
}