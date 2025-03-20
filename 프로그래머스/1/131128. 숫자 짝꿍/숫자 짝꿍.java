import java.util.*;

class Solution {
    public String solution(String X, String Y) {
        int[] nums = new int[10];
        
        for(int i=0; i<X.length(); i++){
            nums[X.charAt(i)-'0']++;
        }
        
        List<Integer> list = new ArrayList<>();
        
        for(int i=0; i<Y.length(); i++){
            int num = Y.charAt(i)-'0';
            if(nums[num] > 0){
                nums[num]--;
                list.add(num);
            }
        }
        
        list.sort(Comparator.reverseOrder());
        StringBuilder sb = new StringBuilder();
        
        for(int a : list){
            sb.append(a+"");
        }
        
        String answer = sb.toString();
        
        return answer.length() == 0 ? "-1" : (answer.startsWith("0") ? "0" : answer);
    }
}