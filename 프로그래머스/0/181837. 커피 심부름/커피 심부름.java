class Solution {
    public int solution(String[] order) {
        int sum = 0;
        for(String str : order){
            if(str.contains("latte")){
                sum+=5000;
            }
            else sum+=4500;
        }
        return sum;
    }
}