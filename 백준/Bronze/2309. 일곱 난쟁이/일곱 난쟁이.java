import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        Scanner scanner = new Scanner(System.in);
        int[] nums = new int[9];

        for(int i=0; i<9; i++){
            nums[i] = scanner.nextInt();
        }
        for(int i=0; i<7; i++){
            System.out.println(main.solution(nums).get(i));
        }
    }

    public List<Integer> solution(int[] nums) {
        List<Integer> list = Arrays.stream(nums).boxed().collect(Collectors.toList());
        int sum = list.stream().mapToInt(c->c).sum();
        int a=0 , b=0;
        for(int i=0; i<8; i++){
            for(int j=i+1; j<9; j++){
                if(sum-nums[i]-nums[j]==100){
                    a=nums[i];
                    b=nums[j];
                    break;
                }
            }
        }
        final int A = a;
        final int B = b;
        list = list.stream().filter(c-> c!=A && c!=B).sorted().collect(Collectors.toList());
        return list;
    }
}