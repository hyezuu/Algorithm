import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        List<Long> list = new ArrayList<>();
        StringBuilder sb;
        int n = in.nextInt();
        while (n-- > 0) {
            String tmp = in.next();
            if(tmp.length()>=12) continue;
            sb = new StringBuilder(tmp).reverse();
            list.add(Long.parseLong(sb.toString()));
        }

        Collections.sort(list);
        for (long i : list) {
            bw.write(i + "\n");
        }
        bw.flush();
        bw.close();
    }

}
