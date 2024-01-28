import java.util.*;

class Solution {
    public int solution(int[] array, int n) {
        Arrays.sort(array);
        int min = Math.abs(array[0]-n);
        int answer = array[0];
        
        for(int arr : array){
            if(min>Math.abs(arr-n)){
                min = Math.abs(arr-n);
                answer = arr;
            }
        }
        return answer;
    }
}