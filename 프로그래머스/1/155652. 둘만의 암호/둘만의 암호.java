import java.util.*;

class Solution {
    public String solution(String s, String skip, int index) {
        boolean[] skips = new boolean[26];
    
        for(char c : skip.toCharArray()){
            skips[c-'a'] = true;
        }
    
        StringBuilder sb = new StringBuilder();
        for(char c : s.toCharArray()){
            char nextChar = c;
            int count = 0;

            while(count < index){
                nextChar = (char)(((nextChar - 'a' + 1) % 26) + 'a');

                if(!skips[nextChar - 'a']){
                    count++;
                }
            }

            sb.append(nextChar);
        }

        return sb.toString();
    }
}