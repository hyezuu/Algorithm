import java.io.*;
import java.util.*;

public class Main {
   static int n;
   static int[] arr;
   static int max = Integer.MIN_VALUE;
   
   public static void main(String[] args) throws IOException {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       
       n = Integer.parseInt(br.readLine());
       arr = new int[n];
       StringTokenizer st = new StringTokenizer(br.readLine());
       for(int i=0; i<n; i++) {
           arr[i] = Integer.parseInt(st.nextToken());
       }
       
       // i,j,k는 구간을 나누는 경계선
       // [0~i][i+1~j][j+1~k][k+1~n-1]
       for(int i=0; i<n-3; i++) {
           for(int j=i+1; j<n-2; j++) {
               for(int k=j+1; k<n-1; k++) {
                   // 4개 그룹으로 나눠서 각 그룹의 곱을 구함
                   int g1 = getMulti(0, i);
                   int g2 = getMulti(i+1, j);
                   int g3 = getMulti(j+1, k);
                   int g4 = getMulti(k+1, n-1);
                   
                   max = Math.max(max, g1 + g2 + g3 + g4);
               }
           }
       }
       
       System.out.println(max);
   }
   
   static int getMulti(int start, int end) {
       int result = 1;
       for(int i=start; i<=end; i++) {
           result *= arr[i];
       }
       return result;
   }
}