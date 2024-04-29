import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        Arrays.sort(people);
        int lt = 0, rt= people.length-1;
        int cnt = 0;
        while(lt<=rt){
            if(people[lt]+people[rt]<=limit){
                lt++;
            }
            rt--;
            cnt++;
        }
        return cnt;    
        
    }
}