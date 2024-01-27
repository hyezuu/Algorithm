class Solution {
    public int[] solution(int money) {
        int[] answer = new int[2];
        int quantity = money/5500;
        int remainder = money - (5500*quantity);
        answer[0] = quantity;
        answer[1] = remainder;
        
        return answer;
    }
}