class Solution {
    public String solution(String my_string, int[][] queries) {
        for(int[] query : queries){
            String before = my_string.substring(0,query[0]);
            String mid = my_string.substring(query[0],query[1]+1);
            String after = my_string.substring(query[1]+1);
            
            my_string = before+ new StringBuilder(mid).reverse().toString() + after;
        }
        return my_string;
    }
}