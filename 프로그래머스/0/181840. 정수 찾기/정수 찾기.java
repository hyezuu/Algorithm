import java.util.*;

class Solution {
    public int solution(int[] num_list, int n) {
        Arrays.sort(num_list);
        int lt=0, rt=num_list.length-1;
        while(lt<=rt){
            int mid=(lt+rt)/2;
            if(num_list[mid]==n)return 1;
            else if(num_list[mid]>n){
                rt = mid-1;
            }
            else lt = mid+1;
        }
        return 0;
    }
}