import java.util.*;

class Solution {
    public int solution(int[] citations) {
        Arrays.sort(citations);
        int cnt = 0;
        int max = 0;
        for(int i=citations.length-1; i>=0; i--){
            cnt++;
            max = Math.max(Math.min(cnt, citations[i]),max);
        }
        return max;
    }
        
}