class Solution {
    public int solution(int[] date1, int[] date2) {
        return getTotalDate(date1)<getTotalDate(date2)? 1:0;
    }
    public int getTotalDate(int[] date){
        int year = date[0];
        int month = date[1];
        int day = date[2];
        
        return year*360+month*30+day*1;
    }
}