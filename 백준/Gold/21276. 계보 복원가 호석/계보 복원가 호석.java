import java.io.*;
import java.util.*;

public class Main {

  static Map<String, List<String>> childMap;
  static Map<String, List<String>> parentMap;
  static List<String> people;
  static Map<String, Integer> indegree;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());

    StringTokenizer st = new StringTokenizer(br.readLine());
    people = new ArrayList<>();
    childMap = new HashMap<>();
    parentMap = new TreeMap<>();
    indegree = new HashMap<>();

    for (int i = 0; i < n; i++) {
      String name = st.nextToken();
      people.add(name);
      childMap.put(name, new ArrayList<>());
      parentMap.put(name, new ArrayList<>());
      indegree.put(name, 0);
    }

    int m = Integer.parseInt(br.readLine());
    for (int i = 0; i < m; i++) {
      st = new StringTokenizer(br.readLine());
      String child = st.nextToken();
      String parent = st.nextToken();

      childMap.get(child).add(parent);
      indegree.put(parent, indegree.get(parent)+1);
    }

    solve();

  }
  static void solve(){
    List<String> roots = new ArrayList<>();
    StringBuilder sb = new StringBuilder();

    for(String child : childMap.keySet()){
      if(childMap.get(child).isEmpty()){
        roots.add(child);
      }
      else {
        int min = Integer.MAX_VALUE;
        String p = "";

        for (String parent : childMap.get(child)) {
          if(indegree.get(parent) < min){
            min = indegree.get(parent);
            p = parent;
          }
        }
        parentMap.get(p).add(child);
      }
    }

    Collections.sort(roots);

    sb.append(roots.size()).append("\n");

    for(String root : roots){
      sb.append(root).append(" ");
    }

    sb.append("\n");

    for(String parent : parentMap.keySet()){
      sb.append(parent).append(" ");
      sb.append(parentMap.get(parent).size()).append(" ");
      Collections.sort(parentMap.get(parent));
      for(String child : parentMap.get(parent)){
        sb.append(child).append(" ");
      }
      sb.append("\n");
    }

    System.out.println(sb);
  }
}
