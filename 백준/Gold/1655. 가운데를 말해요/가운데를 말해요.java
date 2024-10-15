import java.io.*;
import java.util.*;

class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        //항상 중앙값을 저장하는 우선순위 큐, 내림차순으로 정렬되어있음
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        //중앙값보다 큰 값을 저장하는 우선순위 큐. 오름차순으로 정렬되어있음 (maxHeap보단 큰 값들이 정렬)
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for(int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());

            if(maxHeap.size() == minHeap.size()) {
                maxHeap.offer(num);
            }
            else minHeap.offer(num);

            if(!minHeap.isEmpty() && maxHeap.peek() > minHeap.peek()) {
                int temp = minHeap.poll();
                maxHeap.offer(temp);
                minHeap.offer(maxHeap.poll());
            }

            bw.write(maxHeap.peek() + "\n");
        }


        bw.flush();
        bw.close();
        br.close();
    }
}
