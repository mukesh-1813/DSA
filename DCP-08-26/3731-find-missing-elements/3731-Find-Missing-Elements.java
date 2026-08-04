class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        HashSet<Integer> set  = new HashSet<>();
        int n = nums.length;
        for(int i : nums){
            set.add(i);
        }
       int max = Integer.MIN_VALUE;
       int min = Integer.MAX_VALUE;
       for(int i=0;i<n;i++){
        max  = Math.max(max,nums[i]);
        min = Math.min(min,nums[i]);
       }
        List<Integer> ans = new ArrayList<>();
        for(int i = min;i<max;i++){
            if(!set.contains(i)){
                ans.add(i);
            }
        }
        return ans;
    }
}