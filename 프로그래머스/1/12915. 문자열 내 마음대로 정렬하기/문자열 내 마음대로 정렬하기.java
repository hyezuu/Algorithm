import java.util.*;

class Solution {

    public String[] solution(String[] s, int n) {
        Queue<String> q = new PriorityQueue<>(
            (o1, o2) -> {
                if (o1.charAt(n) == o2.charAt(n)) {
                    return o1.compareTo(o2);
                }
                return o1.charAt(n) - o2.charAt(n);
            }
        );

        for (int i = 0; i < s.length; i++) {
            q.offer(s[i]);
        }

        String[] answer = new String[s.length];

        for (int i = 0; i < s.length; i++) {
            answer[i] = q.poll();
        }

        return answer;
	}
}