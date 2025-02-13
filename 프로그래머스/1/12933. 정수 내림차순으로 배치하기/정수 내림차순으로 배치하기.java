import java.util.*;

class Solution {
    public long solution(long n) {
        char[] tmp = String.valueOf(n).toCharArray();
        Arrays.sort(tmp);
        
        return Long.parseLong(new StringBuilder(String.valueOf(tmp)).reverse().toString());
    }
}