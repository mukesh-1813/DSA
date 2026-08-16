class Solution {
    public int minPenalty(int period, int[] lights, int[] arrivalTime) {
        int max_light =Integer.MIN_VALUE;
        for(int i:lights){
            max_light = Math.max(max_light,i);
        }
        int ans=0;
        for(int n : arrivalTime){
            int r = n%period;
            int wait_time = 0;
             if(r < max_light)wait_time=0;
            else wait_time = period-r;
            ans = Math.max(ans,wait_time);
        }
        return ans;
    }
}