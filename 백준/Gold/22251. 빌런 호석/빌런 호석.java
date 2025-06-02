import java.io.*;
import java.util.*;

public class Main {

  static int N, K;
  static int[] segments = {
      0b1111110, 0b0011000, 0b0110111, 0b0111101, 0b1011001, 0b1101101,
      0b1101111, 0b0111000, 0b1111111, 0b1111101
  };

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken()); // 최대 층 수, 9층..
    K = Integer.parseInt(st.nextToken()); // 최대 보여질 숫자 수 -> 2면 01, 02
    int P = Integer.parseInt(st.nextToken()); // 반전시킬 최대 LED 수
    int X = Integer.parseInt(st.nextToken()); // 실제 멈취있는 층

    solve(P, X);
  }

  static void solve(int p, int x) {
    int cnt = 0;

    for(int i = 1; i <= N; i++) {
      if(i == x) continue;

      int needed = 0;
      int tempX = x, tempI = i;

      // 각 자릿수별로 비교
      for(int pos = 0; pos < K; pos++) {
        int digitX = tempX % 10;
        int digitI = tempI % 10;

        needed += Integer.bitCount(segments[digitX] ^ segments[digitI]);
        if(needed > p) break; // 조기 종료

        tempX /= 10;
        tempI /= 10;
      }

      if(needed <= p) cnt++;
    }

    System.out.println(cnt);
  }
}