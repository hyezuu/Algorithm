import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
  static int[] A, B;
  static List<Integer> result;
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(br.readLine());
    StringTokenizer st = new StringTokenizer(br.readLine());
    A = new int[N];
    for(int i = 0; i < N; i++){
      A[i] = Integer.parseInt(st.nextToken());
    }

    int M = Integer.parseInt(br.readLine());
    st = new StringTokenizer(br.readLine());
    B = new int[M];
    for(int i = 0; i < M; i++){
      B[i] = Integer.parseInt(st.nextToken());
    }

    result = new ArrayList<>();
    solve(A, B, 0, 0);

    StringBuilder sb = new StringBuilder();
    sb.append(result.size()).append('\n');
    for(int i = 0; i < result.size(); i++){
      sb.append(result.get(i)).append(' ');
    }
    System.out.print(sb);
  }

  static void solve(int[] A, int[] B, int aStart, int bStart) {
    int maxVal = 0;
    int maxA = -1, maxB = -1;

    for(int i = aStart; i < A.length; i++) {
      for(int j = bStart; j < B.length; j++) {
        if(A[i] == B[j] && A[i] > maxVal) {
          maxVal = A[i];
          maxA = i;
          maxB = j;
        }
      }
    }

    if(maxVal == 0) {
      return;
    }

    result.add(maxVal);

    solve(A, B, maxA + 1, maxB + 1);
  }
}