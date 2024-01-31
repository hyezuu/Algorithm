class Solution {
    public int solution(String A, String B) {
        int index = 0;
        String newB = B+B;
        index = newB.indexOf(A);
        if(index >= B.length()-1/2){
            return B.length()-index;
        }
        else return index;
    }
}