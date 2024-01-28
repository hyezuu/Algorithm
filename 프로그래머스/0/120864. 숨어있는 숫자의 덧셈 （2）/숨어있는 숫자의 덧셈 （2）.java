import java.util.*;

class Solution {
    public int solution(String my_string) {
        return Arrays.stream(my_string.split("[a-zA-Z]"))
            .filter(c->!c.isEmpty())
            .mapToInt(Integer::parseInt)
            .sum();
    }
}