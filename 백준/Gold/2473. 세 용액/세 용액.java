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
      for(int j=i+1; j<N-1; j++){
        if(i==j) continue;

        long toFind = (solutions[i] + solutions[j])*-1;
        long third = binarySearch(toFind, j+1);

        long sum = (long)solutions[i] + solutions[j] + third;
        if(Math.abs(sum) < Math.abs(min)){
          min = sum;
          answer[0] = solutions[i];
          answer[1] = solutions[j];
          answer[2] = third;
          if(min == 0) break;
        }
      }
    }
    System.out.print(answer[0] + " " + answer[1] + " " + answer[2]);
  }

  private static long binarySearch(long target, int start){
    int end = N - 1;
    if(start > end) return solutions[end];

    long closest = solutions[start];

    while(start <= end){
      int mid = (start + end) / 2;

      if(Math.abs(solutions[mid] - target) < Math.abs(closest - target)){
        closest = solutions[mid];
      }
      if(solutions[mid] == target) return solutions[mid];
      else if(solutions[mid] < target) start = mid + 1;
      else end = mid - 1;
    }

    return closest;
  }
}