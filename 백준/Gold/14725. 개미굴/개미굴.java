import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main {
  static int N, K;
  static StringBuilder sb = new StringBuilder();
  
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    N = Integer.parseInt(br.readLine());

    Trie root = new Trie(0, false);

    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      K = Integer.parseInt(st.nextToken());
      Trie current = root;
      int level = 0;
      for(int j=0; j<K; j++){
        String child = st.nextToken();
        boolean isEnd = j == K-1;
        current = insert(current, child, level++, isEnd);
      }
    }
    dfs(root);
    System.out.println(sb.toString());
  }
  
  static Trie insert(Trie root, String child, int level, boolean isEnd){
    root.children.putIfAbsent(child, new Trie(level, isEnd));
    return root.children.get(child);
  }

  static void dfs(Trie root){
    if(root.isEnd){
      return;
    }
    for(String child : root.children.keySet()){
      Trie current = root.children.get(child);
      int level = current.level;
      sb.append(("-").repeat(level*2)).append(child).append("\n");
      dfs(current);
    }
  }

  static class Trie {
    Map<String, Trie> children;
    int level;
    boolean isEnd;

    public Trie(int level, boolean isEnd) {
      this.children = new TreeMap<>();
      this.level = level;
      this.isEnd = isEnd;
    }
  }
}