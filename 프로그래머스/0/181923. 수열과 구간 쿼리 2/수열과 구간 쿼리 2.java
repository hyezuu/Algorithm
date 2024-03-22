class Solution {
    public int[] solution(int[] arr, int[][] queries) {
        int[] answer = new int[queries.length];
        int idx = 0;
        for(int[] query :queries){
            int min = 1000001;
            for(int i = query[0]; i<=query[1]; i++){
                if(arr[i]>query[2]){
                    min = Math.min(arr[i], min);
                }
            }
            answer[idx++] = min==1000001? -1:min;
        }
        return answer;
    }
}