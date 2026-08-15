class Solution {
    public int longestSubsequence(int[] nums) {
        int xor = 0;
        boolean hasNonZero = false;
        for(int i:nums){
            xor ^=i;
            if(i !=0) hasNonZero = true;
        }
        if(xor !=0)return nums.length;
        if(hasNonZero){
            return nums.length-1;
        }
        return 0;

    }
}