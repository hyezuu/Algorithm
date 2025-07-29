import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

  static int N;
  static PriorityQueue<Problem> problems;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    problems = new PriorityQueue<>();

    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      int deadLine = Integer.parseInt(st.nextToken());
      int reward = Integer.parseInt(st.nextToken());

      problems.offer(new Problem(deadLine, reward));
    }

    System.out.print(solve());
    br.close();
  }

  static Long solve() {
    PriorityQueue<Integer> pq = new PriorityQueue<>();

    while (!problems.isEmpty()) {
      Problem problem = problems.poll();
      pq.offer(problem.reward);
      if (problem.deadLine < pq.size()) {
        pq.poll();
      }
    }

    long sum = 0;

    while (!pq.isEmpty()) {
      sum += pq.poll();
    }

    return sum;
  }

  static class Problem implements Comparable<Problem> {

    int deadLine;
    int reward;

    public Problem(int deadLine, int reward) {
      this.deadLine = deadLine;
      this.reward = reward;
    }

    @Override
    public int compareTo(Problem o) {
      if(this.deadLine == o.deadLine) {
        return this.reward - o.reward;
      }
      return this.deadLine - o.deadLine;
    }
  }
}
