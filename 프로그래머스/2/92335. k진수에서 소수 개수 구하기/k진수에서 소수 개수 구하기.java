class Solution {
    public long solution(int n, int k) {
        String[] strs = Integer.toString(n, k).split("[0]+");
        long result = 0;
        for(String s : strs){
            if(isPrime(Long.parseLong(s))) result++;
        }
        
        return result;
    }
    public boolean isPrime(long k){
        if(k==1) return false;
        for(int i=2; i<=Math.sqrt(k); i++){
            if(k%i==0) return false;
        }
        return true;
    }
}