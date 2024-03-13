class Solution {
    public int[] solution(int[] arr, int[][] intervals) {
        int x1 = intervals[0][0];
        int y1 = intervals[0][1];
        int x2 = intervals[1][0];
        int y2 = intervals[1][1];
        int[] answer = new int[(y1-x1+1)+(y2-x2+1)];

// arr의 1부터 answer배열의 0번째 인덱스에 3개 붙여넣는다. => 0, 1, 2
// arr의 0부터 answer배열의 3번째 인덱스에 5개 붙여넣는다. => 3, 4, 5, 6, 7
        
// - src : 복사하고자 하는 원본 배열
// - srcPos : 원본 배열에서 복사를 시작할 인덱스
// - dest : 복사한 원소를 저장할 대상 배열
// - destPos : 대상 배열에서 복사한 원소를 저장할 시작 위치
// - length : 복사할 원소의 개수
        System.arraycopy(arr, x1, answer, 0, y1-x1+1);
        System.arraycopy(arr, x2, answer, y1-x1+1, y2-x2+1);

        return answer;
    }
}
