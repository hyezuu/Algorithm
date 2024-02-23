import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw= new BufferedWriter(new OutputStreamWriter(System.out));
        while (true){
            String str = br.readLine();
            if(str==null||str.equals("\n")) break;
            StringTokenizer stk = new StringTokenizer(str);
            int a = Integer.parseInt(stk.nextToken());
            int b = Integer.parseInt(stk.nextToken());
            bw.write(a+b+"\n");
        }
        bw.flush();
    }
}