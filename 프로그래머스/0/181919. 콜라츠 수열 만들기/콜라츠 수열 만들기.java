import java.util.*;

class Solution {
    public List<Integer> solution(int n) {
        List<Integer> list = new ArrayList<>();
        list.add(n);
        while(n!=1){
            list.add(n = n%2==0? n/2 : 3*n+1);
        }
        return list;
    }
}