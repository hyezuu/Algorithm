import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int tan : tangerine){
            map.put(tan, map.getOrDefault(tan,0)+1);
        }
        Integer[] arr = new Integer[map.size()];
        
        int i = 0;
        for(int a : map.keySet()){
            arr[i++] = map.get(a);
        }
        Arrays.sort(arr, Comparator.reverseOrder());
        
        for(i=0; i<arr.length; i++){
            k-=arr[i];
            if(k<=0){
                return i+1;
            }
        }
        return map.size();
    }
}