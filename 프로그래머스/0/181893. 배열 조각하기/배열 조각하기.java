import java.util.*;

class Solution {
    public int[] solution(int[] arr, int[] query) {
        Deque<Integer> deque = new ArrayDeque<>();
        
        for(int a : arr){
            deque.add(a);
        }
        int size = 0;
        for(int i=0; i<query.length; i++){
            size = deque.size();
            if(i%2==0){
                for(int j=1; j<size - query[i] ; j++){
                    deque.removeLast();
                }
            }
            else {
                for(int j=0; j<query[i]; j++){
                    deque.removeFirst();
                }
            }
        }
        int[] answer = new int[deque.size()];
        int idx = 0;
        for(int a : deque){
            answer[idx++] = a;
        }
        return answer;
    }
}