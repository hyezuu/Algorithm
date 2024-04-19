class Solution {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder();
        String[] arr = s.split("");
        int cnt = 0;
        for(String a : arr){
            sb.append(cnt%2 == 0? a.toUpperCase() : a.toLowerCase()); 
            if(a.equals(" ")) cnt = 0;
            else cnt ++;
        }
        return sb.toString();
    }
}