class Solution {
    public String solution(String s) {
        
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        
        for(String a : s.split(" ")){
            min = Math.min(Integer.parseInt(a), min);
            max = Math.max(Integer.parseInt(a), max);
        }
        
        return min+" "+max;
    }
}