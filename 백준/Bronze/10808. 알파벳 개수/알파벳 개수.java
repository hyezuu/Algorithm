import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = br.readLine();
        bw.write(T.solution(str));
        bw.flush();
    }

    public String solution(String str) {
        int[] alphabetArr = new int[26];
        StringBuilder sb = new StringBuilder();
        for(char c : str.toCharArray()){
            int a = c-'a';
            alphabetArr[a] = alphabetArr[a]+1;
        }
        for(int a : alphabetArr){
            sb.append(a).append(" ");
        }
        return sb.toString();
    }
}
