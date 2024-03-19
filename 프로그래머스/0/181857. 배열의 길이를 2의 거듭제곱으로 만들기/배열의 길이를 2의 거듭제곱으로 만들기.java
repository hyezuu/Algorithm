class Solution {
    public int[] solution(int[] arr) {
        String len = Integer.toBinaryString(arr.length)+"";
        if(Integer.parseInt(new StringBuilder(len).reverse().toString())==1) return arr;
        else {
            int[] answer = new int[(int)(Math.pow(2,len.length()))];
            System.arraycopy(arr,0,answer,0,arr.length);
            return answer;
        }
    }
}