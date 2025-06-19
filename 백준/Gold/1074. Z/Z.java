import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  static int N, r, c;
  static long result = 0;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    r = Integer.parseInt(st.nextToken());
    c = Integer.parseInt(st.nextToken());

    int size = 1<<N;

    recursion(0, 0, size*size);

    System.out.println(result);
  }
  static void recursion(int sy, int sx , int size){
    if(size == 1) return;

    int half = size >> 1;
    long quarter = (long) half*half;

    if(r < sy + half && c < sx + half){
      recursion(sy, sx, half);
    }
    else if(r < sy + half && c >= sx + half){
      result += quarter;
      recursion(sy, sx+half, half);
    }
    else if(r >= sy + half && c < sx + half){
      result += quarter*2;
      recursion(sy+half, sx, half);
    }
    else{
      result += quarter*3;
      recursion(sy+half, sx+half, half);
    }
  }
}