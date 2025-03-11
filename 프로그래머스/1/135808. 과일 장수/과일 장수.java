import java.util.*;

class Solution {
    public int solution(int k, int m, int[] score) {
        Arrays.sort(score);
        
        int total = 0;
        
        for(int i=score.length%m; i<score.length-1; i+=m){
            total+= score[i]*m;
        }
        
        return total;
    }
}