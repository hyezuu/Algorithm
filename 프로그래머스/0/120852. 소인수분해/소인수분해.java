import java.util.*;

class Solution {
    public int[] solution(int n) {
        String str= "";
        for(int i=2; i<=n; i++){
            boolean isPrime= true;
            if(n%i==0){
                for(int j=2; j<=i; j++){
                    if(i%j==0&&i!=j){
                        isPrime= false;
                    }
                }
                if(isPrime){
                    str += i+" ";
                }
            }    
        }
        return Arrays.stream(str.split(" ")).mapToInt(Integer::parseInt).toArray();
    }
}