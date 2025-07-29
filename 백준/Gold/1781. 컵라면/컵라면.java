import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

  static int N;
  static Problem[] problems;

  //4
  //1 50
  //2 30
  //3 60
  //3 70

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    problems = new Problem[N];

    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      int deadLine = Integer.parseInt(st.nextToken());
      int reward = Integer.parseInt(st.nextToken());

      problems[i] = new Problem(deadLine, reward);
    }

    System.out.print(solve());
    br.close();
  }

  static Long solve() {
    Arrays.sort(problems, Comparator.comparingInt(p -> p.deadLine));
    PriorityQueue<Problem> pq = new PriorityQueue<>(Comparator.comparingInt(p -> p.reward));

    for (Problem problem : problems) {
      pq.offer(problem);
      if (problem.deadLine < pq.size()) {
        pq.poll();
      }
    }
    long sum = 0;

    while (!pq.isEmpty()) {
      sum += pq.poll().reward;
    }

    return sum;
  }

  static class Problem {

    int deadLine;
    int reward;

    public Problem(int deadLine, int reward) {
      this.deadLine = deadLine;
      this.reward = reward;
    }
  }
}
