class Solution {
    public int solution(String s) {
        String[] strs = {"zero", "one", "two", "three", "four", 
                         "five", "six", "seven", "eight", "nine"};
        
        for(int i=0; i<10; i++){
            s = s.replace(strs[i], i+"");
        }
        
        return Integer.parseInt(s);
    }
}