class Solution {
    public boolean predictTheWinner(int[] nums) {
       return take_function(nums,0,nums.length-1) >=0;
    }

    public int take_function(int[] arr, int i, int j) {
        if (i > j)
            return 0;

        if (i == j)
            return arr[i];

        int take_left = arr[i] - take_function(arr, i + 1, j);
        int take_right = arr[j] - take_function(arr, i, j - 1);

        return Math.max(take_left, take_right);
    }
}