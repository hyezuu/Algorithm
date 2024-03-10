class Solution {
    public int solution(int[] arr1, int[] arr2) {
        if(arr1.length>arr2.length){
            return 1;
        }
        else if(arr2.length>arr1.length){
            return -1;
        }
        else {
            int sum1 = 0;
            int sum2 = 0;
            for(int a : arr1){
                sum1+=a;
            }
            for(int b : arr2){
                sum2+=b;
            }
            if(sum1>sum2) return 1;
            else if(sum2>sum1) return -1;
            else return 0;
        }
    }
}