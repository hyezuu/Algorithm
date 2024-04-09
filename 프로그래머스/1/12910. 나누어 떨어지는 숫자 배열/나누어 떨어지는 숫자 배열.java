import java.util.*;

class Solution {
    public int[] solution(int[] arr, int divisor) {
        List<Integer> list = new ArrayList<>();
        
        for(int i : arr){
            if(i%divisor==0) list.add(i);
        }
        if(list.isEmpty()) return new int[]{-1};
        else {
            int[] answer = new int[list.size()];
            int idx = 0;
            for(int a : list){
                answer[idx++] = a;
            }
            Arrays.sort(answer);
            return answer;
        }
    }
}