class Solution {
    public String solution(int a, int b) {
        int[] months = {0,31,29,31,30,31,30,31,31,30,31,30,31};
        String[] date = {"SUN","MON","TUE","WED","THU","FRI","SAT"};
        int days = 0;
        for(int i=0; i<a; i++){
            days+=months[i];
        }
        days+=b;
        return date[(days+4)%7];
    }
}