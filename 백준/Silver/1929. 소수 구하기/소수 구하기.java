import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
  static int N, M;
  static int[][] map;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());

    boolean[] isNotPrime = new boolean[M+1];
    isNotPrime[0] = true;
    isNotPrime[1] = true;

    StringBuilder sb = new StringBuilder();

    for(int i=2; i<=Math.sqrt(M); i++){
      if(!isNotPrime[i]){
        for(int j=i*i; j<=M; j+=i){
          isNotPrime[j] = true;
        }
      }
    }

    for(int i=N; i<=M; i++){
      if(!isNotPrime[i]){
        sb.append(i).append('\n');
      }
    }

    System.out.print(sb);
  }
}