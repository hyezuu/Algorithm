import java.util.stream.Collectors;
import java.util.*;
class Solution {
    public String solution(String my_string) {
        return Arrays.stream(my_string.split(""))
            .map(c -> Character.isUpperCase(c.charAt(0))? 
                 String.valueOf(Character.toLowerCase(c.charAt(0))) : c)
            .sorted()
            .collect(Collectors.joining());
                             
    }
}