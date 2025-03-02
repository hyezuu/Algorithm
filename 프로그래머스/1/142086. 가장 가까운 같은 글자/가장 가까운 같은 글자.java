import java.util.*;

class Solution {
    public int[] solution(String s) {
        int[] arr = new int[26];
        Arrays.fill(arr, -1);
        
        int[] answer = new int[s.length()];
        
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            
            answer[i] = arr[c-'a'] == -1 ? -1 : i-arr[c-'a'];
            arr[c-'a'] = i;
        }
        return answer;
    }
}