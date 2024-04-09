import java.util.*;

class Solution {
    public int[] solution(int[] arr) {
        if(arr.length==1){
            arr[0] = -1;
            return arr;
        }
        int[] ca = Arrays.copyOf(arr, arr.length);
        Arrays.sort(ca);
        
        int[] answer = new int[arr.length-1];
        int idx = 0;
        
        for(int a : arr){
            if(a!=ca[0]) answer[idx++] = a;
        }
        return answer;

    }
}