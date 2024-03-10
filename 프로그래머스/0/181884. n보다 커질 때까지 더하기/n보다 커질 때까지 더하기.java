class Solution {
    public int solution(int[] numbers, int n) {
        int sum = 0, i=0;
        while(sum<=n){
            sum+=numbers[i];
            i++;
        }
        return sum;
    }
}