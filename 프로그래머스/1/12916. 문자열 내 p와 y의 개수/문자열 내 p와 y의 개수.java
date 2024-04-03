class Solution {
    boolean solution(String s) {
        int cnt = 0;
        for(char a : s.toLowerCase().toCharArray()){
            if(a=='p') cnt ++;
            else if(a=='y') cnt --;
        }
        return cnt == 0 ? true : false;
    }
}