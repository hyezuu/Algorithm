class Solution {
    public int[] solution(int n, int m) {
        int gcd = getGcd(n,m);
        int lcm = (n*m)/gcd;

        return new int[]{gcd, lcm};
    }
    public int getGcd(int n, int m){
        int a = Math.max(n,m);
        int b = Math.min(n,m);

        int rmd = a%b;
        while(rmd!=0){
            a = b;
            b = rmd;
            rmd = a%b;
        }
        return b;
    }
}