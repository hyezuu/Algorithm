import java.util.*;

class Solution {
    public int[] solution(int[] arr, int k) {
        Set<Integer> set = new LinkedHashSet<>();
        
        for(int a : arr){
            set.add(a);
        }
        int[] answer = new int[k];
        int idx = 0;
        Arrays.fill(answer, -1);
        for(int a : set){
            answer[idx++] = a;
            if(idx==k) break;
        }
        return answer;
    }
}