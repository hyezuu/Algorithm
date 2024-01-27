import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.*;


class Solution {
    public int[] solution(int[] numbers, String direction) {
        List<Integer> listNumbers = Arrays.stream(numbers).boxed().collect(Collectors.toList());
        
        if(direction.equals("right")){
            listNumbers.add(0,numbers[numbers.length-1]);
            listNumbers.remove(numbers.length);
        }
        else {
            listNumbers.remove(0);
            listNumbers.add(numbers.length-1, numbers[0]);
        }
        return listNumbers.stream().mapToInt(Integer::intValue).toArray();
    }
}