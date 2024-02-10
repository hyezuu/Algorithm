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
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < count; i++) {
            String arr = sc.nextLine();
            char[] c0 = arr.split(" ")[0].toCharArray();
            char[] c1 = arr.split(" ")[1].toCharArray();
            Arrays.sort(c0);
            Arrays.sort(c1);
            if (String.valueOf(c0).equals(String.valueOf(c1))) {
                sb.append("Possible").append("\n");
            } else sb.append("Impossible").append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
    }
}