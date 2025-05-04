class Solution {
    public int[] solution(int brown, int yellow) {
        int total = brown + yellow;
        int x = 0;
        int y = 0;
        for(int i=3; i<=Math.sqrt(total); i++){
            if(total%i==0){
                int tmp = total/i;
                if((tmp-2+i)*2==brown){
                    x = Math.max(tmp, i);
                    y = Math.min(tmp, i);
                }
            }
        }
        return new int[]{x, y};
    }
}