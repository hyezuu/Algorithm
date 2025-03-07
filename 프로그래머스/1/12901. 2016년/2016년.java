class Solution {
    public String solution(int a, int b) {
        int[] date = {0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        String[] days = {"FRI","SAT","SUN","MON","TUE","WED","THU"};
        
        int totalDate = 0;
        
        for(int i=1; i<a; i++){
            totalDate += date[i];
        }
        
        totalDate += b;
        
        return days[(totalDate-1)%7];
    }
}