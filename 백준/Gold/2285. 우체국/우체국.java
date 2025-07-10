import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    Village[] villages = new Village[N];
    long total = 0;

    for (int i = 0; i < N; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int index = Integer.parseInt(st.nextToken());
      int people = Integer.parseInt(st.nextToken());
      villages[i] = new Village(index, people);
      total += people;
    }

    Arrays.sort(villages);
    
    long mid = (total + 1)/2;
    long sum = 0;
    for(Village v : villages) {
      sum += v.people;
      if(sum >= mid) {
        System.out.print(v.index);
        break;
      }
    }
  }
  static class Village implements Comparable<Village>{
    int index;
    int people;

    public Village(int index, int people) {
      this.index = index;
      this.people = people;
    }

    @Override
    public int compareTo(Village o) {
      return this.index - o.index;
    }
  }
}