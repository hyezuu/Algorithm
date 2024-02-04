import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line1 = scanner.nextLine();
        String line2 = scanner.nextLine();

        System.out.println(solution(line1, line2));
    }

    public static String solution(String line1, String line2) {
        String[] str = line1.split(" ");
        int n = Integer.parseInt(str[0]);
        int x = Integer.parseInt(str[1]);

        String answer = "";

        for (String str2 : line2.split(" ")) {
            if (Integer.parseInt(str2) < x) {
                answer += str2+" ";
            }
        }
        return answer;
    }
}