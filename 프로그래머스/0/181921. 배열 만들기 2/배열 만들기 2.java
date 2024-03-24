import java.util.*;

class Solution {
    public int[] solution(int l, int r) {
        ArrayList<Integer> list = new ArrayList<>();
        for(int i=l; i<=r; i++){
            String tmp = i+"";
            if(tmp.replaceAll("[0|5]","").isEmpty()) list.add(i);
        }
        if(list.isEmpty()) list.add(-1);
        return list.stream().mapToInt(i->i).toArray();
    }
}