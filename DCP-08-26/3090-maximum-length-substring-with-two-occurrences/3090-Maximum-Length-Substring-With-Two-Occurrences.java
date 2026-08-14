class Solution {
    public int maximumLengthSubstring(String s) {
        int n = s.length();
        Map<Character,Integer> map = new HashMap<>();
        int l =0;
        int max = Integer.MIN_VALUE;
        for(int i =0;i<n;i++){
                char ch = s.charAt(i);
                map.put(ch,map.getOrDefault(ch,0)+1);
                while(map.get(ch)>2){
                    char k = s.charAt(l);
                    map.put(k,map.get(k)-1);
                    l++;
                }
                if(map.get(ch)==0)map.remove(ch);
                max = Math.max(max,i-l+1);
        }
        return max;

    }
}