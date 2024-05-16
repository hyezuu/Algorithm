import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Main main = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<String> list = new ArrayList<>();

        while(true){
            String tmp = br.readLine();
            if(tmp.equals("#"))break;
            else list.add(tmp);
        }
        System.out.println(main.solution(list));
    }

    public String solution(List<String> list) {
        StringBuilder sb = new StringBuilder();
        char[] vowels = {'a','e','i','o','u'};
        for(String str : list){
            String tmp = str.toLowerCase();
            int cnt= 0;
            for(char a : tmp.toCharArray()){
                for(char v : vowels){
                    if(a==v) {
                        cnt++;
                        break;
                    }
                }
            }
            sb.append(cnt).append("\n");
        }
        return sb.substring(0,sb.length()-1);
    }


}