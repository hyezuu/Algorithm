import java.util.*;

class Solution {
    public int solution(int i, int j, int k) {
        int answer = 0;
        for(int n=i; n<=j; n++){
            answer += Arrays.stream(String.valueOf(n).split(""))
                .filter(c-> c.equals(String.valueOf(k)))
                .count();
        }
        return answer;
}
}