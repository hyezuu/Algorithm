import java.util.*;

class Solution {
    public int solution(int[] array) {
        long count = Arrays.stream(Arrays.toString(array).split(""))
            .filter(c->c.equals("7")).count();
        return (int)count;
    }
}