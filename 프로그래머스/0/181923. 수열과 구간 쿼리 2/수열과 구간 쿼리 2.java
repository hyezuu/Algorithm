import java.util.*;

class Solution {
    public int[] solution(int[] arr, int[][] queries) {
        int[] answer = new int[queries.length];
        int i=0 ; 
        
        for(int[] query : queries) {
            int s = query [0], e = query [1], k= query [2];
            int[] tmp = new int[e-s+1];
            
            System.arraycopy(arr, s, tmp, 0, tmp.length);
            Arrays.sort(tmp);
            
            int value = -1;
            for(int n : tmp){
                if(n>k){
                    value=n;
                    break;
                } 
            }
            answer[i++] = value;
        }
        return answer;
        
    }
}