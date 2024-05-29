import java.util.*;

class Solution {
    public int[] solution(int[] arr) {
        List<Integer> list = new ArrayList<>();
        int i=0;
        while(i<arr.length){
            int last = list.size()-1;
            if(list.isEmpty()||list.get(last)<arr[i]) list.add(arr[i++]);
            else list.remove(last);
        }
        return list.stream().mapToInt(n->n).toArray();
    }
}
// import java.util.*;

// class Solution {
//     public int[] solution(int[] arr) {
//         Stack<Integer> stack = new Stack<>();
//         int i = 0;
//         while(i<arr.length){
//             if(stack.isEmpty()||stack.peek()<arr[i]) stack.push(arr[i++]);
//             else stack.pop();
//         }
        
//         int[] stk = new int[stack.size()];
//         int idx = 0;
//         for(int k : stack){
//             stk[idx++] = k;
//         }
//         return stk;
//     }
// }