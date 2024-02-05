import java.util.*;

public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        Scanner scanner = new Scanner(System.in);
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            list.add(scanner.nextLine());
        }
        for (int i = 0; i < 3; i++) {
            System.out.println(main.solution(list).get(i));
        }

    }

    public List<String> solution(List<String> strings) {
        List<String> list = new ArrayList<>();
        for (String str : strings) {
            char[] c = str.trim().toCharArray();
            int count = 0;
            for (char a : c) {
                if (a == '1') {
                    count++;
                }
            }
            if(count == 0){
                list.add("D");
            }
            else if(count == 1){
                list.add("C");
            }
            else if(count == 2){
                list.add("B");
            }
            else if(count == 3){
                list.add("A");
            }
            else list.add("E");
        }
        return list;
    }
}