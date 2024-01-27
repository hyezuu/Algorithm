import java.util.*;
import java.util.stream.*;

class Solution {
    public String solution(int age) {
        String answer = String.valueOf(age);
        return Arrays.stream(answer.split(""))
            .map(c -> String.valueOf((char)(Character.getNumericValue(c.charAt(0))+('a'))))
            .collect(Collectors.joining());
        
    }
}