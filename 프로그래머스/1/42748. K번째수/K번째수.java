class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
    
        for(int i=0; i<commands.length; i++){
            int s = commands[i][0]-1;
            int e = commands[i][1]-1;
            int k = commands[i][2]-1;
            
            int[] tmp = new int[e-s+1];
            
            for(int j=s, idx=0; j<=e; j++){
                tmp[idx++] = array[j];
            }
            sort(tmp);
            answer[i] = tmp[k];
        }
        return answer;
    }
    
    private int[] sort(int[] arr){
        for(int i=0; i<arr.length-1; i++){
            int minIdx = i;
            for(int j=i+1; j<arr.length; j++){
                if(arr[minIdx] > arr[j]){
                    minIdx = j;
                }
            }
            int tmp = arr[i];
            arr[i] = arr[minIdx];
            arr[minIdx] = tmp;
        }
        return arr;
    }
}