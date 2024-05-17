import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        Main main = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int antenna = Integer.parseInt(br.readLine());
        int eyes = Integer.parseInt(br.readLine());

        System.out.print(main.solution(antenna, eyes));
    }

    public String solution(int antenna, int eyes) {
        StringBuilder sb = new StringBuilder();

        if (antenna >= 3 && eyes <= 4) {
            sb.append("TroyMartian\n");
        }
        if (antenna <= 6 && eyes >= 2) {
            sb.append("VladSaturnian\n");
        }
        if (antenna <= 2 && eyes <= 3) {
            sb.append("GraemeMercurian\n");
        }

        return sb.toString();
    }

}