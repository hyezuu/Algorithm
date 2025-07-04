import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  static int R, C, T;
  static int[] dx = {0, -1, 0, 1}; //시계방향
  static int[] dy = {1, 0, -1, 0};
  static int[][] map;
  static int[] purifier = new int[2];

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int total = 0;

    R = Integer.parseInt(st.nextToken());
    C = Integer.parseInt(st.nextToken());
    T = Integer.parseInt(st.nextToken());

    map = new int[R][C];
    int k = 0;

    for (int i = 0; i < R; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < C; j++) {
        map[i][j] = Integer.parseInt(st.nextToken());
        if (map[i][j] > 0) {
          total += map[i][j];
        }
        if (map[i][j] < 0) {
          purifier[k++] = i;
        }
      }
    }

    System.out.print(solve());
  }

  static int solve() {
    int t = 0;
    int total = 0;

    while (t++ < T) {
      spread();
      purifyTop();
      purifyBottom();
    }

    for(int i=0; i<R; i++){
      for(int j=0; j<C; j++){
        if(map[i][j] <= 0) continue;
        total += map[i][j];
      }
    }
    return total;
  }
  static void purifyTop() {
    int top = purifier[0]; //2

//    total -= map[top-1][0];

    //위 -> 아래
    for(int i=top-1; i>0; i--){
      map[i][0] = map[i-1][0];
    }

    //제일 위 (오->왼)
    for(int j=0; j<C-1; j++){
      map[0][j] = map[0][j+1];
    }

    //제일 오른쪽 (아래->위)
    for(int i=0; i<top; i++){
      map[i][C-1] = map[i+1][C-1];
    }

    //제일 아래 (왼->오)
    for(int j=C-1; j>1; j--){
      map[top][j] = map[top][j-1];
    }

    map[top][1] = 0;
  }

  static void purifyBottom() {
    int bottom = purifier[1];//3

//    total -= map[bottom+1][0];

    //아래->위
    for(int i=bottom+1; i<R-1; i++){
      map[i][0] = map[i+1][0];
    }

    //제일 아래(오->왼)
    for(int j=0; j<C-1; j++){
      map[R-1][j] = map[R-1][j+1];
    }

    //제일 오른쪽(위->아래)
    for(int i=R-1; i>bottom; i--){
      map[i][C-1] = map[i-1][C-1];
    }

    //제일 위
    for(int j=C-1; j>1; j--){
      map[bottom][j] = map[bottom][j-1];
    }

    map[bottom][1] = 0;
  }

  static void spread() {
    int[][] tmp = new int[R][C];

    tmp[purifier[0]][0] = -1;
    tmp[purifier[1]][0] = -1;


    for (int i = 0; i < R; i++) {
      for (int j = 0; j < C; j++) {
        if(map[i][j] > 0 && map[i][j] < 5) {
          tmp[i][j] += map[i][j];
          continue;
        }
        if(map[i][j] >= 5){
          int diffusion = map[i][j] / 5;
          int cnt = 0;

          for(int d = 0; d < 4; d++){
            int ny = i + dy[d];
            int nx = j + dx[d];

            if(ny < 0 || ny >= R || nx < 0 || nx >= C) continue;
            if(map[ny][nx] < 0) continue;

            tmp[ny][nx] += diffusion;
            cnt++;
          }
          tmp[i][j] += map[i][j] - diffusion * cnt;
        }
      }
    }
    map = tmp;
  }
}
