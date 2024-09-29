class Solution {
    public String solution(int n, int t, int m, int p) {
        StringBuilder sb = new StringBuilder();
        StringBuilder ans = new StringBuilder();
        int cnt=0;
        for(int i=0; i<t; i++){
            while(sb.length()<=(m*i)+p){
                sb.append(Integer.toString(cnt++,n));
            }
            ans.append(sb.toString().charAt((m*i)+p-1));
        }
        return ans.toString().toUpperCase();
    }
}