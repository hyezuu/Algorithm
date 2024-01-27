import java.util.*;

class Solution {
    public int[] solution(String my_string) {
        return Arrays.stream(my_string.split(""))
            .filter(c -> Character.isDigit(c.charAt(0)))
            .mapToInt(Integer::parseInt)
            .sorted()
            .toArray();
        
    }
}