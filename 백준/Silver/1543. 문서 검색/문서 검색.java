import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    public String solution(String docs, String word) {
        int len1 = docs.length();
        String docs2 = docs.replace(word,"");
        int len2 = docs2.length();
        int answer = (len1-len2)/word.length();
        return answer+"";
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
