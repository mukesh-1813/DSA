class Solution {
    public int smallestNumber(int n, int t) {
        int ans  =n;
        while(true){
            int pro = product(ans);
            if(pro%t==0)return ans;
            ans++;
        }
        
    }
    private int product(int n ){
        int pro=1;
        while(n!=0){
            int rem = n%10;
            pro *= rem;
            n = n/10;
        }
        return pro;
    }
}