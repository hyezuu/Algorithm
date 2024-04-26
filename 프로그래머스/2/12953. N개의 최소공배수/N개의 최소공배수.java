class Solution {
    public int solution(int[] arr) {
        int ans = 1;
        for(int i=0; i<arr.length; i++){
            ans = getLCM(ans, arr[i]);
        }
        return ans;
    }
    
    public int getLCM(int a, int b){
        int num = a*b;
        while(b!=0){
            int r = a%b;
            a = b;
            b = r;  
        }
        return num/a;
    }
}