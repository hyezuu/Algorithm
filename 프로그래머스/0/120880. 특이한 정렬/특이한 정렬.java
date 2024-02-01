import java.util.*;
import java.util.stream.*;


class Solution {
    public int[] solution(int[] numlist, int n) {
        int[] num1 = Arrays.stream(numlist).boxed()
            .sorted(Comparator.reverseOrder())
            .mapToInt(Integer::intValue)
            .toArray();
        //내림차순 정렬. 큰값이 앞에온다.
        
        for(int i=0; i<num1.length; i++){//num1.length-1 번 비교연산 수행한다.
            for(int j=0; j<num1.length-1-i; j++){//현재값이랑 다음에 들어올 값중에 큰값들어오면 바꿔줄거임
                if(Math.abs(num1[j]-n)>Math.abs(num1[j+1]-n)){
                    int temp = num1[j+1];
                    num1[j+1] = num1[j];
                    num1[j] = temp;                    
                }
            }
        }
                
        return num1;
    }
}