import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        int cnt = 0;
        Map<Character, Character> map = new HashMap<>();

        map.put('(', ')');
        map.put('{', '}');
        map.put('[', ']');


        for (char a : s.toCharArray()) {
            if (map.containsKey(a)) cnt++;
        }
        if (s.length() != cnt * 2) return 0;

        for (int i = 0; i < s.length(); i++) {
            char tmp = s.charAt(0);
            Stack<Character> stack = new Stack<>();
            boolean chk = true;
            for (char a : s.toCharArray()) {
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
            s = s.substring(1) + tmp;
        }
        return answer;

    }
}