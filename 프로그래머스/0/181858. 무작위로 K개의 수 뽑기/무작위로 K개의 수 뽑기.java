import java.util.*;

class Solution {
    public int[] solution(int[] arr, int k) {
        Set<Integer> set = new LinkedHashSet<>();
        int[] answer = new int[k];
        Arrays.fill(answer,-1);
        for(int i=0, j=0; i<arr.length; i++){
            if(j==k) break;
            if(set.add(arr[i])) answer[j++] = arr[i];
        }
        return answer;
    }
}