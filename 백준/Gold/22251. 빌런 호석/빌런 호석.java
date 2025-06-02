import java.io.*;
import java.util.*;

public class Main {

  static int N, K;
  static int[] segments = {
      0b1111110,
      0b0011000,
      0b0110111,
      0b0111101,
      0b1011001,
      0b1101101,
      0b1101111,
      0b0111000,
      0b1111111,
      0b1111101
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

  static void solve(int p, int x){
    int[] floor = toSegments(x);
    int cnt = 0;
    //층수 다돔
    outer : for(int i = 1; i<= N; i++){
      if(i == x) continue;

      int[] targetFloor = toSegments(i);
      int needed = 0;

      //반전할 비트수 다더하기
      for(int j=0; j<K; j++){
        needed += Integer.bitCount(floor[j] ^ targetFloor[j]);
        if(needed > p) continue outer;
      }
      
      cnt++;
    }

    System.out.println(cnt);
  }

  //숫자 층을 비트 배열로바꿔줌
  static int[] toSegments(int num) {
    int[] arr = new int[K];
    //0으로 초기화
    Arrays.fill(arr, 0b1111110);
    int i = K - 1;
    int tmp = num;
    while (tmp > 0) {
      //뒷자리부터 채움(각자릿수)
      arr[i--] = segments[tmp % 10];
      tmp /= 10;
    }
    return arr;
  }
}