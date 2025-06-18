import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  static int[] arr;
  static int N;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    N = Integer.parseInt(br.readLine());
    arr = new int[N];
    StringTokenizer st = new StringTokenizer(br.readLine());

    for(int i = 0; i < N; i++){
      arr[i] = Integer.parseInt(st.nextToken());
    }

    System.out.println(solve());
  }

  static int solve(){
    int cnt = 0;
    for(int i : arr){
      if(isPrime(i)) cnt++;
    }
    return cnt;
  }
  static boolean isPrime(int n){
    if(n==1) return false;
    for(int i=2; i<=Math.sqrt(n); i++){
      if(n%i==0) return false;
    }
    return true;
  }
}