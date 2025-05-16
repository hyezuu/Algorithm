import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

  static char[][] board;
  static Map<String, Integer> map;
  static int[] dy = {-1, 0, 1, 1, -1, -1, 0, 1};
  static int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
  static int n, m, k;
  static int maxLen;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());
    k = Integer.parseInt(st.nextToken());

    board = new char[n][m];

    for (int i = 0; i < n; i++) {
      board[i] = br.readLine().toCharArray();
    }

    maxLen = 0;
    map = new LinkedHashMap<>();

    for (int i = 0; i < k; i++) {
      String tmp = br.readLine();
      map.put(tmp, 0);
      maxLen = Math.max(maxLen, tmp.length());
    }

    System.out.println(solve());
  }

  static String solve() {
    Queue<Node> queue = new LinkedList<>();
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        String s = String.valueOf(board[i][j]);
        queue.offer(new Node(new int[]{i, j}, s));
        if (map.containsKey(s)) {
          map.put(s, map.get(s) + 1);
        }
      }
    }

    StringBuilder sb;

    while (!queue.isEmpty()) {
      Node node = queue.poll();

      if (node.value.length() > maxLen) {
        break;
      }

      sb = new StringBuilder(node.value);

      int y = node.position[0];
      int x = node.position[1];

      for (int i = 0; i < 8; i++) {
        int ny = (y + dy[i] + n) % n;
        int nx = (x + dx[i] + m) % m;
        sb.append(board[ny][nx]);
        String s = sb.toString();
        queue.offer(new Node(new int[]{ny, nx}, s));
        if (map.containsKey(s)) {
          map.put(s, map.get(s) + 1);
        }
        sb.deleteCharAt(sb.length() - 1);
      }
    }

    sb = new StringBuilder();

    for (String str : map.keySet()) {
      sb.append(map.get(str)).append("\n");
    }

    return sb.toString();
  }

  static class Node {

    int[] position;
    String value;

    Node(int[] position, String value) {
      this.position = position;
      this.value = value;
    }
  }
}

