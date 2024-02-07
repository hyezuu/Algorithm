import java.util.*;

public class Main {
    public static void main(String[] args) {
        Main T = new Main();
        Scanner scanner = new Scanner(System.in);
        int cnt = scanner.nextInt();
        int[] call = new int[cnt];
        for(int i=0; i<cnt; i++){
            call[i] = scanner.nextInt();
        }
        System.out.print(T.solution(cnt, call));
    }
    int y = 0;
    int m = 0;
    public String solution(int cnt, int[] call) {
        StringBuilder sb = new StringBuilder();
        Map<Character, Integer> map = new HashMap<>();
        for(int i=0; i<cnt; i++){
            y = map.getOrDefault('Y',0) +
                    ((call[i]/30)*10+10);
            map.put('Y', y);
            m = map.getOrDefault('M',0) +
                    (((call[i]/60)+1)*15);
            map.put('M', m);
        }
        if(map.get('Y').equals(map.get('M'))){
            sb.append("Y M ").append(map.get('Y'));
        } else if (map.get('M')<map.get('Y')) {
            sb.append("M ").append(map.get('M'));
        }
        else sb.append("Y ").append(map.get('Y'));

        return sb.toString();
    }
}
