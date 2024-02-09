import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Main T = new Main();
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Scanner sc = new Scanner(System.in);
        int count = sc.nextInt();
        sc.nextLine();
        String[][] str = new String[count][2];
        for (int i = 0; i < count; i++) {
            String arr = sc.nextLine();
            str[i][0] = arr.split(" ")[0];
            str[i][1] = arr.split(" ")[1];
        }
        bw.write(T.solution(count, str));
        bw.flush();
    }

    public String solution(int count, String[][] str) {
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<count; i++) {
            char[] c0 = str[i][0].toCharArray();
            char[] c1 = str[i][1].toCharArray();
            Arrays.sort(c0);
            Arrays.sort(c1);
            if (String.valueOf(c0).equals(String.valueOf(c1))) {
                sb.append("Possible").append("\n");
            }
            else sb.append("Impossible").append("\n");
        }
        return sb.toString();
    }
}
