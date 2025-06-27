import java.util.*;

class Solution {
    static String str;
    static int min;
    
    public int solution(String s) {
        str = s;
        min = s.length();
        
        for(int i=0; i<s.length()/2; i++){
            min = Math.min(compress(i+1),min);
        }
        return min;
    }
    
    int compress(int c){
        int len = 0;
        //10개면 - 4개의 토큰
        int tokens = str.length()/c + (str.length()%c == 0 ? 0 : 1);
        String prev = str.substring(0, c);
        int cnt = 1;
        
        for(int i=1; i<tokens; i++){
            String current = subs(i, c);
            if(prev.equals(current)){
                cnt++;
            }
            else {
                len += c + (cnt == 1 ? 0 : (int)Math.log10(cnt)+1);
                cnt = 1;
                prev = current;
                if(len>min) break;
            }
        }
        
        len += prev.length() + (cnt == 1 ? 0 : (int)Math.log10(cnt)+1);
        return len;
    }
    String subs (int i, int c){
        return str.substring(i*c, Math.min((i+1)*c, str.length()));
    }
}