import java.util.*;

class Solution {
    public int solution(int balls, int share) {
        if(share==balls|| share == 0){
            return 1;
        }
        else return solution(balls-1, share-1) + solution(balls-1, share);
    }
/*    아래는 시간초과
    public int solution(int balls, int share) {
        Map<String, Integer> memo = new HashMap<>();
        String key = balls + "," + share;
        
        if (memo.containsKey(key)) {
            return memo.get(key);
        }

        if (share == balls || share == 0) {
            return 1;
        } else {
            int result = solution(balls - 1, share - 1) + solution(balls - 1, share);
            memo.put(key, result);
            return result;
        }
    }
*/
}