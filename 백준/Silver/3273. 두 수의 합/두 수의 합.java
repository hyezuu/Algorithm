import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {


  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());
    int[] arr = new int[n];

    StringTokenizer st = new StringTokenizer(br.readLine());

    for(int i=0; i<n; i++){
      arr[i] = Integer.parseInt(st.nextToken());
    }

    int x = Integer.parseInt(br.readLine());

    System.out.println(solve(arr, n, x));
  }

  public static int solve(int[] arr, int n, int x) {
    Arrays.sort(arr);

    int lt = 0, rt = n-1;
    int cnt = 0;

    while(lt < rt){
      int sum = arr[lt] + arr[rt];

      if(sum == x){
        cnt++;
        lt++;
        rt--;
      }
      else if(sum < x){
        lt++;
      }
      else{
        rt--;
      }
    }
    return cnt;
  }
}