import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public int solution(String before, String after) {
        String sb = Arrays.stream(before.split("")).sorted().collect(Collectors.joining());
        String ab = Arrays.stream(after.split("")).sorted().collect(Collectors.joining());
        return sb.equals(ab) ? 1 : 0 ;
    }
}