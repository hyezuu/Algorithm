import java.util.*;

class Solution {
    public int[] solution(int N, int[] stages) {
        int[] arr = new int[N+1];
        
        for(int stage : stages){
            arr[stage-1]++;
        }

        FailureRate[] failureRates = new FailureRate[N];
        
        int length = stages.length;
        failureRates[0] = new FailureRate(1, (double)arr[0]/length);
        
        for(int i=1; i<N; i++){
            length-=arr[i-1];
            if(length==0){
                failureRates[i] = new FailureRate(i+1, 0);
            }
            else failureRates[i] = new FailureRate(i+1, (double)arr[i]/length);
        }
        
        Arrays.sort(failureRates);
        
        int[] answer = new int[N];
        int i=0;
        for(FailureRate failureRate : failureRates){
            answer[i++] = failureRate.idx;
        }
        
        return answer;
    }
}
class FailureRate implements Comparable<FailureRate>{
    int idx;
    double rate;
    
    public FailureRate(int idx, double rate){
        this.idx = idx;
        this.rate= rate;
    }
    
    @Override
    public int compareTo(FailureRate o){
        if(this.rate==o.rate){
            return Integer.compare(this.idx, o.idx);
        }
        return Double.compare(o.rate, this.rate);
    }
}