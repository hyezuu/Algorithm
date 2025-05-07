class Solution {
    public int solution(int[] arr) {
        int answer = arr[0];
        for(int i=1; i<arr.length; i++){
            int gcd = getGcd(answer, arr[i]);
            answer = (answer * arr[i])/gcd;
        }
        return answer;
    }
    
    public int getGcd(int a, int b){
        int rm = a%b;
        if(rm==0) return b;
        return getGcd(b, rm);
    }
}