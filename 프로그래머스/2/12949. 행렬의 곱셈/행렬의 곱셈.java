class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        int y = arr1.length;
        int p = arr1[0].length;
        int x = arr2[0].length;
        int[][] answer = new int[y][x];
        
        for(int i=0; i<y; i++){
            for(int j=0; j<x; j++){
                for(int k=0; k<p; k++){
                    answer[i][j] += arr1[i][k] * arr2[k][j];
                }
            }
        }
        return answer;
    }
}