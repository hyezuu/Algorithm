import java.util.*;

class Solution {
    public int[] solution(int[] fees, String[] records) {
        int dt = fees[0], df = fees[1], ut = fees[2], uf = fees[3];
        
        Map<Integer, Integer> parkingMap = new HashMap<>();
        Map<Integer, Integer> timeMap = new TreeMap<>();
        
        for(String record : records){
            String[] tmp = record.split(" ");
            int carNumber = Integer.parseInt(tmp[1]);
            int totalMinutes = convertToTotalTime(tmp[0]);
            
            if(tmp[2].equals("IN")){
                parkingMap.put(carNumber, totalMinutes);
            }
            else {
                int times = totalMinutes - parkingMap.get(carNumber);
                timeMap.put(carNumber, timeMap.getOrDefault(carNumber,0)+times);
                parkingMap.remove(carNumber);
            }
        }
        for(int carNumber : parkingMap.keySet()){
            int times = convertToTotalTime("23:59") - parkingMap.get(carNumber);
            timeMap.put(carNumber, timeMap.getOrDefault(carNumber,0)+times);
        }
        int[] answer = new int[timeMap.size()];
        
        int i=0;
        for(int carNumber : timeMap.keySet()){
            int time = timeMap.get(carNumber);
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