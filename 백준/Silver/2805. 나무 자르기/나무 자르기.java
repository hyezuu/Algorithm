import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Objects;
import java.util.StringTokenizer;

public class Main {

  static int N, M;
  static int[] heights;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());

    heights = new int[N];
    st = new StringTokenizer(br.readLine());

    for (int i = 0; i < N; i++) {
      heights[i] = Integer.parseInt(st.nextToken());
    }

    System.out.println(binarySearch());
  }

  static int binarySearch() {
    int lt = 0, rt = 1_000_000_000;
    int answer = 0;
    while (lt <= rt) {
      int mid = (lt + rt) / 2;

      if (isAvailable(mid)) {
        lt = mid+1;
        answer = mid;
      } else {
        rt = mid - 1;
      }
    }
    return answer;
  }

  static boolean isAvailable(int mid) {
    int tmp = M;
    for (int i = 0; i < N; i++) {
      if (heights[i] > mid) {
        tmp -= (heights[i] - mid);
      }
      if (tmp <= 0) {
        return true;
      }
    }
    return false;
  }
}
