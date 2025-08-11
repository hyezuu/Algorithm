import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
  static int N;
  static long[] solutions;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    N = Integer.parseInt(br.readLine());

    solutions = new long[N];

    StringTokenizer st = new StringTokenizer(br.readLine());

    for (int i = 0; i < N; i++) {
      solutions[i] = Integer.parseInt(st.nextToken());
    }

    Arrays.sort(solutions);
    solve();
  }

  private static void solve() {
    long min = Long.MAX_VALUE;
    long[] answer = new long[3];

    for(int i=0; i<N-2; i++){
      int left = i + 1;
      int right = N - 1;

      while(left < right){
        long sum = solutions[left] + solutions[right] + solutions[i];

        if(Math.abs(sum) < Math.abs(min)){
          min = sum;
          answer[0] = solutions[left];
          answer[1] = solutions[right];
          answer[2] = solutions[i];

          if(min == 0) break;
        }

        if(sum < 0) left++;
        else right--;
      }
      if(min == 0) break;
    }

    Arrays.sort(answer);
    System.out.print(answer[0] + " " + answer[1] + " " + answer[2]);
  }
}