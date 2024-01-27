class Solution {
    public double solution(int[] numbers) {
        int size = numbers.length;
        int sum = 0;
        for(int i=0; i<size; i++){
            sum += numbers[i];
        }
        return (double)sum/size;
    }
}