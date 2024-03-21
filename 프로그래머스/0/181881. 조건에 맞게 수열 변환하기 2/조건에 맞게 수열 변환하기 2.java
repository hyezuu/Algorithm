class Solution {
    public int solution(int[] arr) {
        int max = 0;
        for(int i=0; i<arr.length; i++){
            int cnt = 0;
            while((arr[i]>=50&&arr[i]%2==0)||(arr[i]<50&&arr[i]%2!=0)){
                if(arr[i]>=50&&arr[i]%2==0) arr[i]/=2;
                else arr[i]=arr[i]*2+1;
                cnt++;
            }
            max = Math.max(max,cnt);
        }
        return max;
    }
}