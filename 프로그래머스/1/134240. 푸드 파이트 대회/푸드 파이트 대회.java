class Solution {
    public String solution(int[] food) {
        StringBuilder sb = new StringBuilder();
        for(int i=1; i<food.length; i++){
            int tmp = food[i]/2;
            if(tmp>=1){
                sb.insert(sb.length()/2, ((i+"").repeat(tmp)).repeat(2));
            }
        }
        sb.insert(sb.length()/2, 0);
        return sb.toString();
    }
}