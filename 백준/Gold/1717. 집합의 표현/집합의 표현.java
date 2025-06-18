import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
  static int n, m;
  final static String T = "yes";
  final static String F = "no";
  static int[] parents;
  static StringBuilder sb = new StringBuilder();

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());

    parents = new int[n+1];

    for(int i=0; i<=n; i++){
      parents[i] = i;
    }

    for(int i=0; i<m; i++){
      st = new StringTokenizer(br.readLine());
      int o = Integer.parseInt(st.nextToken());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());

      if(o==0){
        sum(a, b);
      }
      else {
        sb.append(find(a) == find(b) ? T : F).append("\n");
      }
    }

    System.out.println(sb.toString());
  }

  static void sum(int a, int b){
    a = find(a);
    b = find(b);
    parents[b] = a;
  }

  static int find(int a){
    if(parents[a] != a) parents[a] = find(parents[a]);
    return parents[a];
  }
}