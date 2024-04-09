import java.util.*;

class Solution {
    public int[] solution(int[] arr) {
        if(arr.length==1) return new int[]{-1};
        else return 
            Arrays.stream(arr).filter(d -> d!=Arrays.stream(arr).min().getAsInt()).toArray();
    }
}