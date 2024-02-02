import java.util.*;

class Solution {
    public int[] solution(int num, int total) {
        //num이 홀수일때는 num-1 /2 만큼빼줘야 한다.
        //예시)중간값을 3으로 잡기때문에(더작은값). num/2 해버리면 초기값이 더 작아짐
        int initnum = (int)(total/num) - ((num-1)/2);        
        int[] answer = new int[num];
        
        for(int i=0; i< num; i++){
            answer[i] = initnum++;
        }
        return answer;       
    }
}