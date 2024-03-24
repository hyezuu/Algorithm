import java.util.*;

class Solution {
    public int[] solution(int l, int r) {
        ArrayList<Integer> list = new ArrayList<>();
        for(int i=1; i<64; i++){
            int num = Integer.parseInt(Integer.toBinaryString(i))*5;
            if(num >=l && num <=r) list.add(num);
        }
        return list.isEmpty()? new int[]{-1} : list.stream().mapToInt(i->i).toArray();
    }
}