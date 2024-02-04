import java.util.*;

class Solution {
    public int solution(int[][] dots) {
        Set<Double> set = new HashSet<>();
        for(int i=1; i<4; i++){
            set.clear();
            
           int x = dots[0][0] - dots[i][0];
           int y = dots[0][1] - dots[i][1];
            
           double ratio = (double)y/x;
            set.add(ratio);
          
            int dotX = (6-i)/2 + 1;
            x = dots[dotX][0] - dots[6-i-dotX][0];
            y = dots[dotX][1] - dots[6-i-dotX][1];
            
            ratio = (double)y/x;
            if(!set.add(ratio)){
                return 1;
            }
        }
        return 0;
    }
}
