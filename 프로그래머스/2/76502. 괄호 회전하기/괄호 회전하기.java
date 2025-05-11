import java.util.*;

class Solution {
    public int solution(String s) {
        Map<Character, Character> map = new HashMap<>();
        
        map.put(')','(');
        map.put(']','[');
        map.put('}','{');
        
        StringBuilder sb = new StringBuilder(s);
        
        int answer = 0;
        
        for(int i=0; i<sb.length(); i++){
            Stack<Character> stack = new Stack<>();
            for(int j=0; j<sb.length(); j++){
                char cur = sb.charAt(j);
                if(map.containsKey(cur)){
                    if(!stack.isEmpty() && stack.peek().equals(map.get(cur))){
                        stack.pop();
                    }
                    else {
                        stack.push('-');
                        break;
                    }
                }
                else stack.push(cur);
            }
            if(stack.isEmpty()) answer++;
            sb.append(sb.charAt(0));
            sb.deleteCharAt(0);
        }
        return answer;
    }
}