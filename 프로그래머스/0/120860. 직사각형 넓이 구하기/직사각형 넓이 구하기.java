import java.util.*;

class Solution {
    public int solution(int[][] dots) {
        Set<Integer> width = new HashSet<>();
        Set<Integer> height = new HashSet<>();
        for(int[] dot : dots){
            width.add(dot[0]);
            height.add(dot[1]);
        }
        Integer[] widthArr = width.toArray(new Integer[0]);
        Integer[] heightArr = height.toArray(new Integer[0]);
        return Math.abs(widthArr[0] - widthArr[1])
            * Math.abs(heightArr[0] - heightArr[1]);
    }
}