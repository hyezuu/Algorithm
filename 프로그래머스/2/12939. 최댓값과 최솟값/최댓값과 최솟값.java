class Solution {
    public String solution(String s) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(String a : s.split(" ")){
            int tmp = Integer.parseInt(a);
            
            min = Math.min(min, tmp);
            max = Math.max(max, tmp);
        }
        return min+" "+max;
    }
}