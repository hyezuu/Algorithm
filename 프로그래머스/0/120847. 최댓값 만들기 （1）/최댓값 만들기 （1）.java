class Solution {
    public int solution(int[] numbers) {
        int max = 0;
        int maxIndex = 0;
        for(int i=0; i<numbers.length; i++) {
            if(numbers[i]> max){
                max = numbers[i];
                maxIndex = i;
            }
        }
        int secMax = 0;
        for(int j=0; j<numbers.length; j++){
            if(j!= maxIndex){
                if(numbers[j]>secMax){
                    secMax = numbers[j];
                }
            }
        }
        return max*secMax;
    }
}