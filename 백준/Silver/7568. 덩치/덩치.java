import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    int[][] arr = new int[N][2];

    StringTokenizer st;

    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      arr[i][0] = Integer.parseInt(st.nextToken());
      arr[i][1] = Integer.parseInt(st.nextToken());
    }

    int[] rank = new int[N];
    Arrays.fill(rank, 1);

    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {
        if (i != j && arr[j][0] > arr[i][0] && arr[j][1] > arr[i][1]) {
          rank[i]++;
        }
      }
    }

    for (int r : rank) {
      System.out.print(r + " ");
    }
  }
}