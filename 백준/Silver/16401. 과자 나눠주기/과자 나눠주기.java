import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

  static int M, N;
  static int[] snacks;
  static int MAX = 0;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    M = Integer.parseInt(st.nextToken());
    N = Integer.parseInt(st.nextToken());

    snacks = new int[N];

    st = new StringTokenizer(br.readLine());

    for(int i=0; i<N; i++) {
      snacks[i] = Integer.parseInt(st.nextToken());
      MAX = Math.max(MAX, snacks[i]);
    }

    System.out.println(getMaxLength());
  }

  static int getMaxLength() {
    int lt = 1;
    int answer = 0;
    int rt = MAX;

    while (lt <= rt){
      //대충 적합한 값 중간부터 탐색해보자
      int mid = (lt+rt) / 2;
      //나눌 수 있으면 더 키워보자
      //길이 4짜리씩 나눠줄수있는지 볼래
      if(canDivide(mid)){
        //그럼 길이 올려도되더나 ??
        answer = mid;
        lt = mid + 1;
      }
      //어 안되는갑네..그럼.. 그거보다는 좀 줄이자.
      else rt = mid - 1;
    }
    //2명한테 나눠줘야하는 1
    return answer;
  }
  //10 10 15
  //1, 15

  static boolean canDivide(int len){
    if(len == 0) return false;
    int count = 0;
    //10, 9, 8, 7, 6, 5, 4, 3, 2, 1
    //10 -> 4개짜릴르 두명한테 나눠줄수있자나요
    //9 -> 4개짜리를 두명한테 나눠줄수있어서 <- 돌아도
    for(int i=N-1; i>=0; i--){
      count += snacks[i] / len;
      if(count >= M) return true; //ㅇㅇ됨
    }
    //안되던데
    return false;
  }
}