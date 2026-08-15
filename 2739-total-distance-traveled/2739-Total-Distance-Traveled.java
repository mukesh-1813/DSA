class Solution {
    public int distanceTraveled(int mainTank, int additionalTank) {
        int cnt=0;
        int total=0;
        while(mainTank>0){
            mainTank--;
            cnt++;
            
            if(cnt%5==0){
                if(additionalTank>0){
                    mainTank +=1;
                    additionalTank--;

                }
            }
        }
        return cnt*10;
    }
}