import java.util.*;

class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        Queue<String> q1 = new LinkedList<>();
        Queue<String> q2 = new LinkedList<>();
        
        for(String c1 : cards1){
            q1.offer(c1);
        }
        for(String c2 : cards2){
            q2.offer(c2);
        }
        
        for(String word : goal){
            if(word.equals(q1.peek())) q1.poll();
            else if(word.equals(q2.peek())) q2.poll();
            else return "No";
        }
        return "Yes";
        
    }
}