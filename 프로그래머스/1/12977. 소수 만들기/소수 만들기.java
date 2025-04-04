class Solution {
    public int solution(int[] nums) {
        int primeCount = 0;
        
        for(int i=0; i<nums.length-2; i++){
            for(int j=i+1; j<nums.length-1; j++){
                for(int k=j+1; k<nums.length; k++){
                    if(isPrime(nums[i]+nums[j]+nums[k])) primeCount++;
                }
            }
        }

        return primeCount;
    }
    
    private boolean isPrime(int num){
        for(int i=2; i<=Math.sqrt(num); i++){
            if(num%i==0) return false;
        }
        return true;
    }
}