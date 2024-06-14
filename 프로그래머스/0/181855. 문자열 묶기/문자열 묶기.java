import java.util.*;

class Solution {
    public int solution(String[] strArr) {
        int[] arr = new int[31];
        int max = 0;
        for(String str : strArr){
            arr[str.length()]++;
        }
        
        for(int len : arr){
            max = Math.max(max, len);
        }
        return max;
    }
}