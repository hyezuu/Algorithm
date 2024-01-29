import java.util.*;

class Solution {
    public int[] solution(int n) {
        
        LinkedHashSet<Integer> primeNum = new LinkedHashSet<>();
        int i = 2;
        while(i<=n){
            if(n%i==0){
                primeNum.add(i);
                n/=i;
            }
            else i++;
        }
        return primeNum.stream().mapToInt(Integer::intValue).toArray();
        
        // String str= "";
        // for(int i=2; i<=n; i++){
        //     boolean isPrime= true;
        //     if(n%i==0){
        //         for(int j=2; j<=i; j++){
        //             if(i%j==0&&i!=j){
        //                 isPrime= false;
        //             }
        //         }
        //         if(isPrime){
        //             str += i+" ";
        //         }
        //     }    
        // }
        // return Arrays.stream(str.split(" ")).mapToInt(Integer::parseInt).toArray();
    }
}