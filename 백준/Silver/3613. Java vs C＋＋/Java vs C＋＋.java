import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    public String solution(String str) {
        char[] chars = str.toCharArray();
        StringBuilder sb = new StringBuilder();
        boolean isC = false;
        boolean isJava = false;
        for(int i=0; i<str.length(); i++){

            if(chars[0]=='_'||Character.isUpperCase(chars[0])||str.endsWith("_")){
                return "Error!";
            }
            if(chars[i]=='_'){
                if(isJava) return "Error!";
                else {
                    if(chars[i+1] == '_'||Character.isUpperCase(chars[i+1])) return "Error!";
                    sb.append(Character.toUpperCase(chars[i+1]));
                    i++;
                    isC = true;
                }
            }
            else if(Character.isUpperCase(chars[i])){
                if(isC) return "Error!";
                else{
                    sb.append('_').append(Character.toLowerCase(chars[i]));
                    isJava = true;
                }
            }
            else sb.append(chars[i]);
        }
         return sb.toString();
    }

    public static void main(String[] args) throws Exception {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = br.readLine();
        bw.write(T.solution(str));
        bw.flush();
    }
}
