class Solution {
    public int[] solution(int numer1, int denom1, int numer2, int denom2) {

        int denom = denom1*denom2;
        int numer = denom2*numer1 + denom1*numer2 ;
        
        int gcd = getGcd(Math.max(denom,numer),Math.min(denom,numer));
        
        return new int[]{numer/gcd , denom/gcd};
    }
    public int getGcd (int bigger, int smaller){
        int remainder = bigger%smaller;
        if(remainder == 0){ //a>b
            return smaller;
        }
        return getGcd(smaller, remainder);
    }
}