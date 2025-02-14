class Solution {
    public String solution(String phone_number) {
        
        int starCount = phone_number.length()-4;
        
        return "*".repeat(starCount)+phone_number.substring(starCount);
    }
}