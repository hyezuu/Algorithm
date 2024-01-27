class Solution {
    public int[] solution(int[] num_list) {
        int size = num_list.length;
        int[] newArray = new int[size];
        
        for(int i=0; i< size; i++){
            newArray[i] = num_list[size-1-i];
        }
        return newArray;
    }
}