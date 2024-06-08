class Solution {
    public int solution(int[] num_list) {
        int len = num_list.length;
        
        return len>=11 ? sum(num_list) : multiple(num_list);
    }
    
    public int multiple(int[] num_list){
        int multi = 1;
        for(int num : num_list){
            multi*=num;
        }
        return multi;
    }
    
    public int sum(int[] num_list){
        int sum = 0;
        for(int num : num_list){
            sum+=num;
        }
        return sum;
    }
}