import java.util.*;

class Solution {
    public int[] solution(int[] fees, String[] records) {
        int dt = fees[0], df = fees[1], ut = fees[2], uf = fees[3];
    
        Map<Integer, Integer> times = new TreeMap<>();
        
        for(String record : records){
            String[] tmp = record.split(" ");
            int carNumber = Integer.parseInt(tmp[1]);            
            int time = tmp[2].equals("IN") ? -1 : 1;
            
            time *= convertToTotalTime(tmp[0]);
            times.put(carNumber, times.getOrDefault(carNumber,0)+time);
        }
        
        int[] answer = new int[times.size()];
        int i=0;
        
        for(int carNumber : times.keySet()){
            int time = times.get(carNumber);
            if(time < 1){
                time+=convertToTotalTime("23:59");
            }
            int fee = df;
            int extraTime = time-dt;
            if(extraTime>0){
                fee+= ((extraTime/ut) + (extraTime%ut ==0 ? 0 : 1))*uf;
            }
            answer[i++] = fee;
        }
        return answer;
    }
    
    private int convertToTotalTime(String stringTime){
        String[] times = stringTime.split(":");
        return Integer.parseInt(times[0])*60 + Integer.parseInt(times[1]);
    }
}