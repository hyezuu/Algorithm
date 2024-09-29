class Solution {
    public int solution(int n, int k) {
        String[] strs = Integer.toString(n, k).trim().split("[0]+");
        int cnt = 0;
        for(String str : strs){
            if(!str.isEmpty() && isPrime(str)) cnt++;
        }
        return cnt;
    }
    public boolean isPrime(String p){
        if(p.contains("0")) return false;
        
        long n = Long.parseLong(p);
        if(n<=1) return false;
        
        for(int i=2; i<=Math.sqrt(n); i++){
            if(n%i==0) return false;
        }
        return true;
    }
}