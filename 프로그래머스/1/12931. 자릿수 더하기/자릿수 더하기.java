import java.util.*;

public class Solution {
    public int solution(int n) {
        String str = n+"";
        int answer = 0;
        for(String a : str.split("")){
            answer += Integer.parseInt(a);
        }

        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        System.out.println("Hello Java");

        return answer;
    }
}