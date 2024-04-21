class Solution {
    public int solution(int n) {
        int[] arr = new int[n+1];
        for(int i=0; i<=n; i++){
            if(i<=1) arr[i] = i;
            else {
                arr[i] = (arr[i-2]+arr[i-1])%1234567;
            }
        }

        return arr[n];
    }
}