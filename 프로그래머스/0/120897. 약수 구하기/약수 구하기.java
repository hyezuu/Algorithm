import java.util.*;
class Solution {
    public int[] solution(int n) {
        String str= "";
        
        for(int i=1; i<=n; i++){
            if(n%i ==0){
                str+=i+" ";
            }
        }
        return Arrays.stream(str.split(" ")).mapToInt(Integer::parseInt).toArray();
    }
}