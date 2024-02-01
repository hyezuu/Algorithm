import java.util.*;

class Solution {
    public int solution(int[] array) {
        Set<Integer> numSet = new HashSet<>();
        for(int num : array){
            numSet.add(num);
        }//각 항목들 set에 담기
        Integer[] newArr = numSet.toArray(Integer[]::new);
        //중복없앤 값들 배열에 담기
        int[] count = new int[newArr.length];
        //갯수 담은 배열 생성
        for(int i=0; i<newArr.length ; i++){
            for(int j=0; j<array.length; j++){
                if(newArr[i].intValue() == array[j]){
                    count[i]++;
                }
            }
        }
        
        int max = Arrays.stream(count).max().getAsInt();
        
        if(findIndex(count, max).size()>1){
            return -1;
        }
        
        else return newArr[findIndex(count, max).get(0).intValue()].intValue();          
    }
    public List<Integer> findIndex(int[] arr , int value){
        List<Integer> indexList = new ArrayList<>();
        for(int i=0; i<arr.length; i++){
            if(arr[i] == value){
                indexList.add(i);
            }
        }
        return indexList;
    }
}