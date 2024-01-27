import java.util.*;

class Solution {
    public int solution(int n) {
        int sum = 0;
        String str = String.valueOf(n);
        for(char c : str.toCharArray()){
            sum += Character.digit(c, 10);
        }
        return sum;
    }
}