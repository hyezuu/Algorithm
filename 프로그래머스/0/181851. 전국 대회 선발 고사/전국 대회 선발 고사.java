import java.util.*;
class Solution {
    public int solution(int[] rank, boolean[] attendance) {
        int[] arr = new int[101];
        Arrays.fill(arr, -1);
        for(int i=0; i<rank.length; i++){
            if(attendance[i]){
                arr[rank[i]] = i; 
            }
        }
        int k = 10000;
        int answer = 0;
        for(int idx : arr){
            if(k<0) break;
            if(idx!=-1){
                answer+= k*idx;
                k/=100;
            } 
        }
        
        return answer;
        
        
           
//         PriorityQueue<Integer> que = new PriorityQueue<>((a,b)->rank[a]-rank[b]);
        
//         for(int i=0; i<attendance.length; i++){
//             if(attendance[i]) que.offer(i);
//         }
//         int cal = 10000, answer = 0;
//         for(int i=0; i<3; i++){
//             answer += que.poll()*cal;
//             cal/=100;
//         }
//         return answer;
    }
}