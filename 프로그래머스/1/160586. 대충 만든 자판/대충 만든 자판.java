import java.util.*;

class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        
        int[] alphabet = new int[26];
        Arrays.fill(alphabet, -1);
        
        for(String key : keymap){
            
            for(int i=0; i<key.length(); i++){
                char c = key.charAt(i);
                
                //아직 최솟값 할당되지 않은 경우
                if(alphabet[c-'A'] == -1){
                    alphabet[c-'A'] = i+1;
                }
                else alphabet[c-'A'] = Math.min(alphabet[c-'A'], i+1);
            }
        }
        
        int[] result = new int[targets.length];
        int cnt = 0;
        
        for(int i=0; i<targets.length; i++){
            String target = targets[i];
            for(char c : target.toCharArray()){
                if(alphabet[c-'A'] == -1){
                    cnt = -1;
                    break;
                }
                cnt += alphabet[c-'A'];
            }
            result[i] = cnt;
            cnt = 0;
        }
        
        return result;
    }
}