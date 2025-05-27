import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->b-a);
        
        for(int priority :priorities){
            pq.offer(priority);
        }
        
        int len = priorities.length;
        
        boolean[] visited = new boolean[priorities.length];
        
        int i=0;
        
        while(!pq.isEmpty()){
            int peek = pq.peek();
            if(!visited[i%len] && priorities[i%len]==peek){
                pq.poll();
                visited[i%len] = true;
                if(i%len == location){
                    return len-pq.size();
                }
            }
            i++;
        }
        return len-1;
    }
}