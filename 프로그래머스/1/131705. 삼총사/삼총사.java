import java.util.*;

class Solution {
    public int solution(int[] number) {
        Arrays.sort(number);
        int cnt = 0;
        
        for(int i=0; i<number.length; i++){
            for(int j=number.length-1; j>i; j--){
                for(int k=i+1; k<j; k++){
                    if(number[i]+number[j]+number[k]==0) cnt++;
                }
            }
        }
        return cnt;
    }
}