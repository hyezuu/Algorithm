import java.util.*;

class Solution {
    public int solution(int[] numbers, int target) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(numbers[0]);
        q.offer(numbers[0]*-1);
        
        for(int i=1; i<numbers.length; i++){
            int size = q.size();
            for(int j=0; j<size; j++){
                int tmp = q.poll();
                q.offer(tmp+numbers[i]);
                q.offer(tmp+(numbers[i]*-1));
            }
        }
        int cnt = 0;
        
        while(!q.isEmpty()){
            if(q.poll()==target) cnt++;
        }
        return cnt;
        
    }
}