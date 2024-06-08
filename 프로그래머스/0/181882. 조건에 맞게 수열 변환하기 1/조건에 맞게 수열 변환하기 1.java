class Solution {
    public int[] solution(int[] arr) {
        int[] answer = new int[arr.length];
        
        int idx = 0;
        for(int i : arr){
            boolean isEven = i>=50 && i%2==0;
            boolean isOdd = i<50 && i%2==1;
            
            answer[idx++] = isEven ? i/2 : isOdd ? i*2 : i ;
        }
        return answer;
        
        
        
        
        
        
        
        
        
        
        
        // int[] answer = new int[arr.length];
        // for(int i=0; i<arr.length; i++){
        //     int n = arr[i];
        //     if(n>=50 && n%2==0){
        //         n/=2;
        //     }
        //     else if(n<50 && n%2!=0){
        //         n*=2;
        //     }
        //     answer[i] = n;
        // }
        // return answer;
    }
}