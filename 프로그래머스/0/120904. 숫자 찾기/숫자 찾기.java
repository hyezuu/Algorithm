class Solution {
    public int solution(int num, int k) {
        String str = String.valueOf(num);
        if(str.contains(String.valueOf(k))){
            return str.indexOf(String.valueOf(k))+1;
        }
        else return -1;
    }
}