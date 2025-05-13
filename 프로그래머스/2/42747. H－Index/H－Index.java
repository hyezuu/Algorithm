import java.util.*;

class Solution {
    public int solution(int[] citations) {
        Arrays.sort(citations);
        int cnt = 0;
        int max = Integer.MIN_VALUE;
        for(int i=citations.length-1 ; i>=0 ; i--){
            cnt++;
            max = Math.max(max, Math.min(cnt, citations[i]));
        }  
        //6 5 3 1 0
        return max;
    }
}