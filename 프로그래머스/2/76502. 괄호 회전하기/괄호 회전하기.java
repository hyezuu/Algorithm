import java.util.*;

class Solution {
    public int solution(String s) {
        StringBuilder sb = new StringBuilder(s);
        int answer = 0;
        Map<Character, Character> map = new HashMap<>();

        map.put('(', ')');
        map.put('{', '}');
        map.put('[', ']');


        for (int i = 0; i < s.length(); i++) {
            Stack<Character> stack = new Stack<>();
            boolean chk = true;
            for (char a : sb.toString().toCharArray()) {
                if (map.containsKey(a)) stack.push(a);
                else if (!stack.isEmpty() && map.get(stack.peek()) == a) {
                    stack.pop();
                } 
                else {
                    chk = false;
                    break;
                }
            }
            if (chk&&stack.isEmpty()) answer++;
            
            sb.append(sb.charAt(0));
            sb.deleteCharAt(0);
        }
        return answer;

    }
}