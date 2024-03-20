class Solution {
    public int[] solution(int[] arr) {
         boolean b = false;
        int fi=0, li=0;
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<arr.length; i++) {
            if(!b && arr[i]==2){
                fi=i;
                li=i;
                b= true;
            }
            else if(b && arr[i]==2){
                li = i;
            }
        }
        int[] answer = new int[li-fi+1];
        if(b) System.arraycopy(arr,fi,answer,0,li-fi+1);
        else answer[0] = -1;
        
        return answer;
    }
}