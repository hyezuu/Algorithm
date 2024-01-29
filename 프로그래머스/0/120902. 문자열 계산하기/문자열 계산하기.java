import java.util.*;

class Solution {
    public int solution(String my_string) {
        return Arrays.stream(my_string.replaceAll("- ","-").replaceAll("\\s[+]","").split(" "))
            .mapToInt(Integer::parseInt)
            .sum();
    }
}