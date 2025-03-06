import java.util.*;

class Solution {
    public int[] solution(int k, int[] score) {
        Queue<Integer> q = new PriorityQueue<>(Comparator.comparingInt(a->a));
        int[] answer = new int[score.length];
        
        for(int i=0; i<score.length; i++){
            q.offer(score[i]);
            
            if(q.size() > k){
                q.poll();
            }
            
            answer[i] = q.peek();
        }
        
        return answer;
    }
}