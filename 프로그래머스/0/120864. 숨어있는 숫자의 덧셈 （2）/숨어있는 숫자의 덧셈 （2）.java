import java.util.*;

class Solution {
    public int solution(String my_string) {
        return Arrays.stream(my_string.replaceAll("[a-zA-Z]"," ").split(" "))
            .mapToInt(c-> c.equals("")? 0 : Integer.parseInt(c))
            .sum();
    }
}