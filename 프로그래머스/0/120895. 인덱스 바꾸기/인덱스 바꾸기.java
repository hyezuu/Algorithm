class Solution {
    public String solution(String my_string, int num1, int num2) {
        
        char[] ch = my_string.toCharArray();
        
        ch[num2] = my_string.charAt(num1);
        ch[num1] = my_string.charAt(num2);
        
        return String.valueOf(ch);
    }
}