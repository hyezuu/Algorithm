import java.util.*;

class Solution {
    public int[] solution(int[][] score) {
        
        double[] avg = Arrays.stream(score)
            .mapToDouble(c -> Arrays.stream(c).average().orElse(0.0))
            .toArray();
        
        double[] sortedAvg = Arrays.copyOf(avg, avg.length);
        
        Arrays.sort(sortedAvg);
    
        Map<Double, Integer> map = new HashMap<>();
        
        for(int i=0; i<sortedAvg.length; i++){          
            if(i!=0 && sortedAvg[sortedAvg.length-i-1] == sortedAvg[sortedAvg.length-i]){
                map.put(sortedAvg[sortedAvg.length-i-1],map.get(sortedAvg[sortedAvg.length-i]));
            }
            else map.put(sortedAvg[sortedAvg.length-i-1],i+1);
        }      
        return Arrays.stream(avg).mapToInt(map::get).toArray();
    }
}