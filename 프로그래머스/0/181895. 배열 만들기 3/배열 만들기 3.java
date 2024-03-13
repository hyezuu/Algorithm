class Solution {
    public int[] solution(int[] arr, int[][] intervals) {
        int len = intervals[0][1]-intervals[0][0]+1 
            +intervals[1][1]-intervals[1][0]+1;
        
        int[] answer = new int[len];
        int idx=0;
        for(int[] ar : intervals){
            for(int i=ar[0]; i<=ar[1]; i++){
                answer[idx++] = arr[i];
            }
        }
        return answer;
    }
}