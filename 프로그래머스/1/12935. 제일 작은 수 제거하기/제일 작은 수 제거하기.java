import java.util.*;

class Solution {
  public int[] solution(int[] arr) {
    if (arr.length == 1) return new int[]{-1};
   
    List<Integer> list = new ArrayList<>();
    for (int a : arr) list.add(a);
    list.remove(Collections.min(list));
      
    int[] answer = new int[arr.length - 1];
    for (int i = 0; i < list.size(); i++)answer[i] = list.get(i);
    return answer;
  }
}