import java.util.*;

class Solution {
    public int[] solution(long n) {
        int len = (n+"").length(), idx=0;
    
        int[] answer= new int[len];
        while(n>0){
            answer[idx++] = (int)(n%10);
            n/=10;
        }
        
        return answer;
    }
}