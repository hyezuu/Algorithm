import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
  static int N;
  static int[] solutions;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(br.readLine());
    solutions = new int[N];

    StringTokenizer st = new StringTokenizer(br.readLine());

    for(int i = 0; i < N; i++){
      solutions[i] = Integer.parseInt(st.nextToken());
    }

    solve();
  }
  static void solve() {
    Arrays.sort(solutions);
    
    int lt = 0;
    int rt = N - 1;

    int min = Integer.MAX_VALUE;

    int leftValue = solutions[lt], rightValue = solutions[rt];

    while(lt < rt){
      int sum = solutions[lt] + solutions[rt];
      if(Math.abs(sum) < min){
        min = Math.abs(sum);
        leftValue = solutions[lt];
        rightValue = solutions[rt];
      }
      if(sum == 0) break;
      if(sum < 0) lt++;
      if(sum > 0) rt--;
    }
    System.out.print(leftValue + " " + rightValue);
  }
}

