import java.util.*;

class Solution {
    public String[] solution(String myStr) {
        StringTokenizer stk = new StringTokenizer(myStr, "abc");
        int len = stk.countTokens();
        if(len==0) return new String[] {"EMPTY"};
        else {
            String[] answer = new String[len];
            
            for(int i=0; i<len; i++){
                answer[i] = stk.nextToken();
            }
            return answer;
        }
    }
}