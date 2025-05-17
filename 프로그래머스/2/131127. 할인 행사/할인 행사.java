import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        Map<String, Integer> map = new HashMap<>();
        
        for(int i=0; i<want.length; i++){
            map.put(want[i] ,number[i]);
        }
        
        int cnt = 0;
        int total = want.length;
        
        for(int i=0; i<discount.length; i++){
            String tmp = discount[i];
            if(i>9) {
                if(map.containsKey(discount[i-10])){
                    if(map.get(discount[i-10])==0) total++;
                    map.put(discount[i-10], map.get(discount[i-10])+1);
                }
            }
            if(map.containsKey(tmp)){
                map.put(tmp, map.get(tmp)-1);
                if(map.get(tmp)==0) total--;
            }
            if(total == 0) cnt++;
        }
        return cnt;
    }
}