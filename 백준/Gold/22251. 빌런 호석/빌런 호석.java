import java.io.*;
import java.util.*;

public class Main {

  static int N, K, P, X;
  static int[] segments = {
      0b1111110, 0b0011000, 0b0110111, 0b0111101, 0b1011001,
      0b1101101, 0b1101111, 0b0111000, 0b1111111, 0b1111101
  };
  static int[] xSegments;
  static int cnt = 0;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken()); // 최대 층 수, 9층..
    K = Integer.parseInt(st.nextToken()); // 최대 보여질 숫자 수 -> 2면 01, 02
    P = Integer.parseInt(st.nextToken()); // 반전시킬 최대 LED 수
    X = Integer.parseInt(st.nextToken()); // 실제 멈취있는 층

    solve();
  }

  static void solve() {
    xSegments = new int[K];
    Arrays.fill(xSegments, 0b1111110);
    int tmp = X;
    int idx = K-1;
    while (tmp > 0){
      xSegments[idx--] = segments[tmp % 10];
      tmp /= 10;
    }

    dfs(P, 0, 0);
    System.out.println(cnt);
  }

  static void dfs(int remain, int pos, int current) {
    if(pos == K) {
      if(current >= 1 && current <= N && current != X) {
        cnt++;
      }
      return;
    }

    for(int i=0; i<10; i++){
      int needed = Integer.bitCount(xSegments[pos] ^ segments[i]);

      if(needed > remain) continue;
      dfs(remain - needed, pos+1, current*10 + i);
    }
  }
}