import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

  static int[] arr;
  static int n, k;
  static StringBuilder sb;
  static final String EXIT = "0 0";

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String line = br.readLine();
    sb = new StringBuilder();

    while (!line.equals(EXIT)) {
      StringTokenizer st = new StringTokenizer(line);

      n = Integer.parseInt(st.nextToken());
      k = Integer.parseInt(st.nextToken());
      st = new StringTokenizer(br.readLine());
      arr = new int[n];
      for (int i = 0; i < n; i++) {
        arr[i] = Integer.parseInt(st.nextToken());
      }
      solve(k);
      line = br.readLine();
    }
    System.out.println(sb.toString());
  }

  public static void solve(int k) {
    if (k == arr[0]) {
      sb.append("0\n");
      return;
    }
    List<List<List<Integer>>> list = new ArrayList<>();

    list.add(new ArrayList<>());
    int level = 0;
    List<Integer> currentGroup = new ArrayList<>();
    currentGroup.add(arr[0]);

    int kLevel = -1;
    int kGroupIdx = -1;
    int idx = 0;
    int parentSize = 1;
    int childSize = 1;

    for (int i = 1; i < n; i++) {
      if (arr[i] > arr[i - 1] + 1) {
        list.get(level).add(currentGroup);
        currentGroup = new ArrayList<>();
        idx++;
        if (i == 1 || (level > 0 && parentSize == list.get(level).size())) {
          parentSize = childSize;
          childSize = 0;
          list.add(new ArrayList<>());
          idx = 0;
          level++;
        }
      }
      childSize++;
      currentGroup.add(arr[i]);

      if (arr[i] == k) {
        kLevel = level;
        kGroupIdx = idx;
      }
    }
    if (!currentGroup.isEmpty()) {
      list.get(level).add(currentGroup);
    }

    if (kLevel < 2) {
      sb.append("0\n");
      return;
    }

    List<List<Integer>> parentLevel = list.get(kLevel-1);
    int start = 0, end = 0;
    int answer = 0;
    for (List<Integer> parentGroup : parentLevel) {
      end += parentGroup.size();
      if (start <= kGroupIdx && kGroupIdx < end) {
        List<List<Integer>> childLevel = list.get(kLevel);
        for (int i = start; i < Math.min(end, childLevel.size()); i++) {
          if (i != kGroupIdx) {
            answer += childLevel.get(i).size();
          }
        }
        break;
      }
      start = end;
    }

    sb.append(answer).append("\n");
  }
}