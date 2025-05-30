import java.io.*;
import java.util.*;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());
    int[] A = new int[N];
    int[] B = new int[M];

    st = new StringTokenizer(br.readLine());

    for(int i = 0; i < N; i++){
      A[i] = Integer.parseInt(st.nextToken());
    }


    st = new StringTokenizer(br.readLine());

    for(int i = 0; i < M; i++){
      B[i] = Integer.parseInt(st.nextToken());
    }

    int lt = 0, rt = 0;
    StringBuilder sb = new StringBuilder();

    for(int i=0; i<N+M; i++){
      if(lt == N){
        sb.append(B[rt++]).append(" ");
      }
      else if(rt == M){
        sb.append(A[lt++]).append(" ");
      }
      else if(A[lt]<B[rt]){
        sb.append(A[lt++]).append(" ");
      }
      else{
        sb.append(B[rt++]).append(" ");
      }
    }

    System.out.println(sb);
  }
}