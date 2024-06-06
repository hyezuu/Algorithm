class Solution {
    public int solution(int[] num_list) {
        int odd = 0;
        int even = 0;
        for(int i=0; i<num_list.length; i++){
            if((i+1)%2==1) even+=num_list[i];
            else odd+=num_list[i];
        }
        return Math.max(even, odd);
        
        
        
        
        
        
        
        
        // int oddSum = 0,evenSum = 0;
        // for(int i=1; i<=num_list.length; i++){
        //     if(i%2!=0){
        //         oddSum+=num_list[i-1];
        //     }
        //     else evenSum+=num_list[i-1];
        // }
        // return Math.max(oddSum,evenSum);
    }
}