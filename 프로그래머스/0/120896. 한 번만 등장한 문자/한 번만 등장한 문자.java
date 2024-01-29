import java.util.*;

class Solution {
    public String solution(String s) {
        char[] ch = s.toCharArray();
        for(int i=0; i<s.length(); i++){
            for(int j=i+1; j<s.length(); j++){
                if(String.valueOf(s.charAt(i)).equals(String.valueOf(s.charAt(j)))){
                    ch[i] = '-';
                    ch[j] = '-';
                }
            }
        }
        Arrays.sort(ch);
        return String.valueOf(ch).replaceAll("-","");
    }
}