class Solution {
    public int missingInteger(int[] nums) {
        int sum = nums[0];
        for(int i =1;i<nums.length;i++){
            if(nums[i]-nums[i-1] ==1){
                sum +=nums[i];
            }else{
                break;
            }
        }
        while(!contains(nums,sum)){
            sum++;
        }
        return sum;
    }
    private boolean contains(int arr[] , int t){
        for(int i =0;i<arr.length;i++){
            if(arr[i] == t){
                return false;
            }
        }
        return true;
    }
}

