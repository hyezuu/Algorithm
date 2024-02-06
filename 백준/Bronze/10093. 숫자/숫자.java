import java.util.*;

public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        Scanner scanner = new Scanner(System.in);
        long a = scanner.nextLong();
        long b = scanner.nextLong();

        System.out.print(main.solution(a, b));
    }

    public String solution(long a, long b) {
        long max = Math.max(a, b);
        long min = Math.min(a, b);
        long count = min == max ? 0 : max - min - 1;
        StringBuilder sb = new StringBuilder();
        for (long i = min + 1; i < max; i++) {
            sb.append(i).append(" ");
        }
        String answer = count + "\n" + sb.toString();
        return answer.substring(0, answer.length() - 1);
    }
}
