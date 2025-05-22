import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        Queue<int[]> q = new LinkedList<>();
        Map<Integer, Integer> map = new LinkedHashMap<>(); 
        boolean[] chk = new boolean[progresses.length+1];
 
        for(int i=0; i<progresses.length; i++){
            int tmp = (int)Math.ceil((100.0 - progresses[i]) / speeds[i]);
            q.offer(new int[]{i+1, tmp, 0});
        }
        
        chk[0] = true;
        
        while(!q.isEmpty()){
            int[] process = q.poll();
            int chkIdx = process[0];
            int date = process[1];
            int cnt = process[2];
            
            if(chk[chkIdx-1] && date<=0){
                map.put(cnt, map.getOrDefault(cnt, 0)+1);
                chk[chkIdx] = true;
            }
            
            else q.offer(new int[]{chkIdx, date-1, cnt+1});
        }
        
        int[] answer = new int[map.size()];
        int i=0;
        for(int key : map.keySet()){
            answer[i++] = map.get(key);
        }
        return answer;
    }
}