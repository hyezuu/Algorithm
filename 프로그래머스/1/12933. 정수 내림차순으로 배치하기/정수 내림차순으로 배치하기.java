import java.util.*;

class Solution {
    public long solution(long n) {
        Integer[] answer = new Integer[(int)Math.log10(n)+1];
        int idx= 0;
        while(n>0){
            int rm = (int)(n%10);
            answer [idx++] = rm;            
            n/=10;
        }
        
        Arrays.sort(answer, Comparator.reverseOrder());
        StringBuilder sb = new StringBuilder();
        
        for(int a : answer){
            sb.append(a);
        }
        return Long.parseLong(sb.toString());
        }
}