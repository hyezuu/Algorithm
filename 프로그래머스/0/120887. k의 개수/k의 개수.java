import java.util.*;

class Solution {
    public int solution(int i, int j, int k) {
        String str = "";
        
        for(int n=i; n<=j; n++){
            str+= n+"";
        }
        return str.length() - str.replace(k+"","").length();
    }
}