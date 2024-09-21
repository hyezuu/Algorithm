import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> q= new LinkedList<>();
        List<Integer> list = new ArrayList<>();
        for(int i=0; i<progresses.length; i++){
            int tmp = (100-progresses[i])/speeds[i] + ((100-progresses[i])%speeds[i]==0? 0:1);
            q.offer(tmp);
        }
        
        while(!q.isEmpty()){
            int tmp = q.poll();
            int cnt = 1;
            
            while(!q.isEmpty()){
                if(q.peek()<=tmp){
                    cnt++;
                    q.poll();
                }
                else break;
            }
            list.add(cnt);
        }
        int i=0;
        int[] answer = new int[list.size()];
        for(int a : list){
            answer[i++] = a;
        }
        return answer;
    }
}