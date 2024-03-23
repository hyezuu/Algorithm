import java.util.*;
class Solution {
    public int solution(int[] rank, boolean[] attendance) {
        Map<Integer, Integer> map = new HashMap<>();
        int answer = 0;
        
        for(int i=0; i<rank.length; i++){
            map.put(rank[i],i);
        }
        Arrays.sort(rank);
        int cal = 10000;
        
        for(int i=0; i<rank.length; i++){
            int idx = map.get(rank[i]);
            if(attendance[idx]) {
                answer += idx*cal;
                cal/=100;
            }
            if(cal<1) break;
        }
        return answer;
    }
}