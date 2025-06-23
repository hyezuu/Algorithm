import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  static int N;
  static int[] stocks;
  static StringBuilder sb = new StringBuilder();
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    int T = Integer.parseInt(br.readLine());

    while(T--> 0){
      N = Integer.parseInt(br.readLine());
      stocks = new int[N];
      st = new StringTokenizer(br.readLine());
      for(int i = 0; i < N; i++){
        stocks[i] = Integer.parseInt(st.nextToken());
      }
      solve();
    }

    System.out.println(sb);
  }

  static void solve() {
    Wallet wallet = new Wallet(0, 0);
    for(int i= N-1; i >= 0; i--){
      //최댓값이면
      if(stocks[i] > wallet.maxValue){
        wallet.maxValue = stocks[i];
      }
      //아니면
      else {
        wallet.profit += wallet.maxValue- stocks[i];
      }
    }
    sb.append(wallet.profit).append("\n");
  }

  static class Wallet {
    int maxValue;
    long profit;

    public Wallet(int maxValue, int profit) {
      this.maxValue = maxValue;
      this.profit = profit;
    }
  }
}
