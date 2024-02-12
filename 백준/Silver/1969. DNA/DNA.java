import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    public String solution(int n, int m , String[] dna) {
        StringBuilder sb = new StringBuilder();
        int num = 0;
        for(int i=0; i<m; i++){
            int[] apb = new int[26];
            int a = 0;
            char c = 0;
            int max = 0;
            for(int j=0; j<n; j++){
                apb[dna[j].charAt(i)-'A']++;
            }
            for(int k=0; k<26; k++){
                if(apb[k]>max){
                    max = apb[k];
                    c = (char)(k+'A');
                    a = n-max;
                }
            }
            num += a;
            sb.append(c);
        }
        return sb.append("\n").append(num).toString();
    }

    public static void main(String[] args) throws Exception {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer nm = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(nm.nextToken());
        int m = Integer.parseInt(nm.nextToken());
        String[] dna = new String[n];
        for(int i=0; i<n; i++){
            dna[i] = br.readLine();
        }
        bw.write(T.solution(n, m, dna));
        bw.flush();
    }
}
