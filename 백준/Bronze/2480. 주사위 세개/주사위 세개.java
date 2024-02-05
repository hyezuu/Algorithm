import java.util.*;

public class Main{
    public static void main(String[] args){
        Main main = new Main();
        Scanner scanner = new Scanner(System.in);

        List<Integer> list = new ArrayList<>();
        for(int i=0; i<3; i++){
            list.add(scanner.nextInt());
        }


        System.out.print(main.solution(list));
    }
    public int solution(List<Integer> list){
        int count = 1;
        int value = 0;
        int max = 0;
        Set<Integer> set = new HashSet<>();
        for(int i=0; i<list.size(); i++){
            if(!set.add(list.get(i))){
                count++;
                value=list.get(i);
            }
            else if(max<list.get(i)){
                max = list.get(i);
            }
        }
        if(count==3){
            return 10000 + value*1000;
        }
        else if(count==2){
            return 1000 + value*100;
        }
        else return 100*max;
    }
}