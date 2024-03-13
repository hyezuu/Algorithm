import java.util.*;

class Solution {
    public int[] solution(int[] arr, int[] delete_list) {
        Arrays.sort(delete_list);
        List<Integer> list = new ArrayList<>();
        for(int i=0; i<arr.length; i++){
            int lt=0, rt= delete_list.length-1;
            while(lt<=rt){
                int mid = (lt+rt)/2;
                if(delete_list[mid]>arr[i]) rt = mid-1;
                else if(delete_list[mid]<arr[i]) lt= mid+1;
                else {
                    arr[i]=0;
                    break;
                }
            }
            if(arr[i]!=0)list.add(arr[i]);
        }
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}