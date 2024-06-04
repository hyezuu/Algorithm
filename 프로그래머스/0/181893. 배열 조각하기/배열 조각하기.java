import java.util.*;

class Solution {
    public int[] solution(int[] arr, int[] query) {
        int start = 0; 
        int end = arr.length-1;
        for(int i=0; i<query.length; i++){
            if(i%2==0){
                end = start + query[i];
            }
            else start += query[i];
        }
        int len = end-start+1;
        int[] answer = new int[len];
        
        System.arraycopy(arr, start, answer, 0, len);
        return answer;
    }
}