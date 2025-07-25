import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
  static int N;
  static boolean[] notPrimes;


  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(br.readLine());

    notPrimes = new boolean[N+2];
    for(int i = 2; i <= N; i++){
      if(!notPrimes[i]){
        for(int j = i+i; j <= N; j += i){
          notPrimes[j] = true;
        }
      }
    }

    System.out.print(solve());
  }

  static int solve(){
    int lt = 2, rt = 2;

    int cnt = 0;
    int total = 2;

    while (rt <= N){
      if(total < N) {
        rt = getPrime(rt);
        total += rt;
      } else if(total > N){
        total -= lt;
        lt = getPrime(lt);
      } else {
        cnt++;
        rt = getPrime(rt);
        total += rt-lt;
        lt = getPrime(lt);
      }
    }
    return cnt;
  }
  private static int getPrime(int num) {
    while (num <= N && notPrimes[++num]){}
    return num;
  }
}