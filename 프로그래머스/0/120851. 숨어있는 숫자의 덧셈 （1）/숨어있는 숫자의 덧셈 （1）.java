class Solution {
    public int solution(String my_string) {
        int sum = 0;
        for(char c: my_string.toCharArray()){
            if(Character.digit(c,10)!=-1){
                sum+=Character.digit(c,10);
            }
        }
        return sum;
    }
}