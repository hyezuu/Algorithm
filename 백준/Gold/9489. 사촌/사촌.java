import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  static int[] arr;
  static int[] parent;
  static int n, k;
  static StringBuilder sb;
  static final String EXIT = "0 0";

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String line = br.readLine();
    sb = new StringBuilder();

    while (!line.equals(EXIT)) {
      StringTokenizer st = new StringTokenizer(line);

      n = Integer.parseInt(st.nextToken());
      k = Integer.parseInt(st.nextToken());
      st = new StringTokenizer(br.readLine());
      arr = new int[n];
      parent = new int[n];
      for (int i = 0; i < n; i++) {
        arr[i] = Integer.parseInt(st.nextToken());
      }
      solve();
      line = br.readLine();
    }
    System.out.println(sb.toString());
  }

  public static void solve() {
    parent[0] = -1;
    int target = 0;
    int idx = -1;
    for(int i = 1; i < n; i++) {
      if(arr[i]==k) target = i;
      if(arr[i] > arr[i-1]+1){
        idx++;
      }
      parent[i] = idx;
    }
    int cnt = 0;

    if(parent[target] == 0){
      sb.append(cnt).append("\n");
      return;
    }

    for(int i=1; i<n; i++){
      if(parent[i] != parent[target] && parent[parent[i]] == parent[parent[target]])
        cnt++;
    }

    sb.append(cnt).append("\n");
  }
}