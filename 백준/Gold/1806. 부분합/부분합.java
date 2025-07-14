import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
  static int N, S;
  static int[] arr;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    S = Integer.parseInt(st.nextToken());

    arr = new int[N];
    st = new StringTokenizer(br.readLine());

    for(int i = 0; i < N; i++){
      arr[i]= Integer.parseInt(st.nextToken());
    }

    System.out.print(solve());
  }

  static int solve(){
    int lt = 0, rt = 0;
    int sum = 0;
    int min = Integer.MAX_VALUE;
    while(rt < N){
      sum += arr[rt];

      while(sum >= S){
        min = Math.min(min, rt-lt+1);
        sum -= arr[lt++];
      }
      rt++;
    }
    return min == Integer.MAX_VALUE ? 0 : min;
  }
}