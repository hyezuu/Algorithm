import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
  static int N;
  static int[] line;
  static int[] lis;
  static int len = 0;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    N = Integer.parseInt(br.readLine());
    line = new int[N];

    for(int i=0; i<N; i++){
      line[i] = Integer.parseInt(br.readLine());
    }
    System.out.println(solve());
  }

  static int solve(){
    lis = new int[N];
    len = 0;
    for(int i=0; i<N; i++){
      int pos = lowerBound(line[i]);
      lis[pos] = line[i];

      if(pos == len) len++;
    }
    return N - len;
  }
  //target 이상인 첫 번째 위치 찾기
  static int lowerBound(int target){
    int left = 0;
    int right = len;

    while(left < right){
      int mid = (left + right) / 2;

      if(lis[mid] < target){
        left = mid + 1;  // target보다 작으면 오른쪽으로
      } else {
        right = mid;     // target 이상이면 현재 위치가 후보
      }
    }
    return left;
  }
}