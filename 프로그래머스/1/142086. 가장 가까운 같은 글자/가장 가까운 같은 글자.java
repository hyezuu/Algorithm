import java.util.*;

class Solution {
    public int[] solution(String s) {
        int[] arr = new int[26];
        int[] answer = new int[s.length()];
        
        Arrays.fill(arr,-1);
        for(int i=0; i<s.length(); i++){
            int tmp = s.charAt(i)-'a';
            
            if(arr[tmp]==-1) answer[i]= -1;
            else answer[i]= i - arr[tmp];
            
            arr[tmp] = i;
        }
        return answer;
    }
}