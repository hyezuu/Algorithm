import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    public String solution(String docs, String word) {
        return (docs.length()-docs.replace(word,"").length())/word.length()+"";
    }
    public static void main(String[] args) throws Exception {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String docs = br.readLine();
        String word = br.readLine();
        bw.write(T.solution(docs, word));
        bw.flush();
    }
}
