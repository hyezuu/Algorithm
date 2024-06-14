class Solution {
    public int[] solution(int[] arr, int n) {
      int rmd = arr.length%2 == 0 ? 1 : 0;
      for(int i=0; i<arr.length; i++){
          if(i%2==rmd){
              arr[i]+=n;
          }
      }
    
      return arr;
        
        
        
        
        
        
        
        
        
        
        
        
        
        // int len = arr.length;
        // int[] answer = new int[len];
        // if(len%2!=0){
        //     for(int i=0; i<len; i++){
        //         int k = arr[i];
        //         if(i%2==0) k+=n;
        //         answer[i]=k;
        //     }
        // }
        // else{
        //     for(int i=0; i<len; i++){
        //         int k = arr[i];
        //         if(i%2!=0) k+=n;
        //         answer[i]=k;
        //     }
        // }
        // return answer;
    }
}