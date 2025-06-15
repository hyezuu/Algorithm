import java.util.*;

class Solution {
    public int solution(int[] toppings) {
        int cnt = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for(int topping : toppings){
            map.put(topping, map.getOrDefault(topping, 0) + 1);
        }
        int totalCnt = map.size();
        
        Set<Integer> set = new HashSet<>();
        
        int ob = 0;
        int yb = totalCnt;
        
        for(int topping : toppings){
            if(set.add(topping))ob++;
            map.put(topping, map.get(topping) - 1);
            if(map.get(topping) == 0){
                map.remove(topping);
                yb--;
            }
            if(ob==yb) cnt++;
            if(ob>yb)break;
        }
        
        return cnt;
    }
}