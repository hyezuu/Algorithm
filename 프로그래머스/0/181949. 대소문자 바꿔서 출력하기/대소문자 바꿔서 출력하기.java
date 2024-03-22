import java.util.Scanner;

public class Solution {
    public String solution(String a){
        char[] chars = a.toCharArray();
        for(int i=0; i<chars.length; i++){
            if(Character.isUpperCase(chars[i])) chars[i] = Character.toLowerCase(chars[i]);
            else chars[i] = Character.toUpperCase(chars[i]);
        }
        return String.valueOf(chars);
    }
    public static void main(String[] args) {
        Solution T = new Solution();
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        
        System.out.println(T.solution(a));
    }
}