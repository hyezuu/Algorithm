import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        Arrays.sort(people);
        int lt = 0, rt= people.length-1;
        int cnt = 0;
        while(lt<=rt){
            int tmp = people[lt] + people[rt];
            if(tmp > limit){
                cnt++;
                rt--;
            }
            else{
                cnt++;
                rt--;
                lt++;
            }
        }
        return cnt;
    }
}