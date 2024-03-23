import java.util.*;
class Solution {
    public int solution(int[] rank, boolean[] attendance) {
        PriorityQueue<Integer> que = new PriorityQueue<>((a,b)->rank[a]-rank[b]);
        
        for(int i=0; i<attendance.length; i++){
            if(attendance[i]) que.offer(i);
        }
        int cal = 10000, answer = 0;
        for(int i=0; i<3; i++){
            answer += que.poll()*cal;
            cal/=100;
        }
        return answer;
    }
}