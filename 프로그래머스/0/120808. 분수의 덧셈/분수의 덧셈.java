class Solution {
    public int[] solution(int numer1, int denom1, int numer2, int denom2) {
        //기약분수로 나타내는법 -> 최대공약수로 나누기
        //더하려면-> 통분 
        
        //분모 -> denom1과 denom2의 최소공배수 (최소공배수는 두 수 곱해서 최대공약수로 나누면 된다)
        //분자 -> (최소공배수/denom1)*number1 + (최소공배수/denom2)*number2
        //최대공약수 -> 분모와 분자의 최대공약수
        //기약분수 분모 -> 분모 / 최대공약수
        //기약분수 분자 -> 분자 / 최대공약수       
        int gcd1 = getGcd(Math.max(denom1, denom2),Math.min(denom1, denom2));
        int denom = (denom1*denom2)/gcd1;
        int numer = (denom/denom1)*numer1 + (denom/denom2)*numer2 ;
        
        int gcd2 = getGcd(Math.max(denom,numer),Math.min(denom,numer));
        
        int[] answer = {numer/gcd2 , denom/gcd2};
        return answer ;
    }
    public int getGcd (int bigger, int smaller){
        int remainder = bigger%smaller;
        if(remainder == 0){ //a>b
            return smaller;
        }
        return getGcd(smaller, remainder);
    }
}