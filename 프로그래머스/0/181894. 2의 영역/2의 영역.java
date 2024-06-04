import java.util.*;
class Solution {
    public int[] solution(int[] arr) {
        int lt= 0;
        int rt= arr.length-1;
        
        int s = -1;
        int e = -1;
        while(lt<=rt){
            if(arr[lt]==2 && s == -1){
                s = lt;
            }
            if(arr[rt]==2 && e == -1){
                e = rt;
            }
            lt++;
            rt--;
        }
        if(s<0 && e<0) return new int[]{-1};
        s = s<0 ? e: s;
        e = e<0 ? s: e;
        
        int[] answer = new int[e-s+1];
        System.arraycopy(arr , s , answer, 0 , e-s+1);      
        
        return answer;
//       boolean b = false;
//         int fi=0, li=0;
//         for (int i=0; i<arr.length; i++) {
//             if(arr[i]==2){
//                 if(!b){
//                     fi=i;
//                     li=i;
//                     b= true;
//                 }
//                 else li = i;
//             }
//         }
//         int[] answer = new int[li-fi+1];
//         if(b) System.arraycopy(arr,fi,answer,0,li-fi+1);
//         else answer[0] = -1;

//         return answer;
    }
}
