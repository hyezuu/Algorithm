class Solution {
    public int[] solution(int n, int m) {
        
        int gcd = getGCD(n, m);
        int lcm = (n * m)/gcd;
        
        return new int[]{gcd, lcm};
    }
    
    int getGCD(int n, int m){
        
        while(n%m!=0){
            int r = n%m;
            n = m;
            m = r;
        }
        
        return m;
    }
}