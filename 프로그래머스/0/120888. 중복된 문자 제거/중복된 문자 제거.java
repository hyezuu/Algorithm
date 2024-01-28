import java.util.stream.Collectors;
import java.util.*;

class Solution {
    public String solution(String my_string) {
        return Arrays.stream(my_string.split("")).distinct().collect(Collectors.joining());
    }
}