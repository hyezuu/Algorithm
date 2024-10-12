import java.io.*;
import java.util.*;

class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        String[] logs = new String[n];
        for (int i = 0; i < n; i++) {
            logs[i] = br.readLine();
        }

        for(String answer : solution(logs)) {
            System.out.println(answer);
        }
    }

    public static String[] solution(String[] logs) {
        Set<String> set = new TreeSet<>(Comparator.reverseOrder());
        for (String log : logs) {
            String name = log.substring(0, log.length()-5);
            if(log.endsWith("enter")){
                set.add(name);
            }
            else set.remove(name);
        }

        String[] answer = new String[set.size()];

        int idx = 0;

        for(String name : set){
            answer[idx++] = name;
        }

        return answer;
    }

}