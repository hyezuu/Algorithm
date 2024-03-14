import java.util.*;

class Solution {
    public String[] solution(String myString) {
        return Arrays.asList(myString.split("x"))
                        .stream()
                        .filter(x->!x.isEmpty())
                        .sorted()
                        .toArray(String[]::new);
    }
}