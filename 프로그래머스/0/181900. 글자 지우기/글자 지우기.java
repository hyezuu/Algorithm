import java.util.Arrays;

class Solution {
    public String solution(String myString, int[] indices) {
        char[] chars = myString.toCharArray();
        for(int i : indices){
            chars[i] = ' ';
        }
        return String.valueOf(chars).replaceAll(" ","");
    }
}