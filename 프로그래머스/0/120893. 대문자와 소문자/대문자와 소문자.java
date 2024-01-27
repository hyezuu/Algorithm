import java.util.* ;

class Solution {
    public String solution(String my_string) {
        String answer = "";
        for(char ch : my_string.toCharArray()){
            char a = Character.isUpperCase(ch) ? Character.toLowerCase(ch): Character.toUpperCase(ch);
            answer += String.valueOf(a);
        }
            return answer ;
    }
}