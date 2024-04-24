class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        for(int i=0; i<n; i++){
            StringBuilder sb = new StringBuilder();
            String idx1 = Integer.toBinaryString(arr1[i]);
            String idx2 = Integer.toBinaryString(arr2[i]);
            
            idx1 = "0".repeat(n-idx1.length())+idx1;
            idx2 = "0".repeat(n-idx2.length())+idx2;
            
            for(int j=0; j<n; j++){
                boolean chk = idx1.charAt(j)=='1'||idx2.charAt(j)=='1';
                sb.append(chk ? "#" : " ");
            }
            answer[i] = sb.toString();
        }
        return answer;
    }
}