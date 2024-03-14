class Solution {
    public String solution(int[] numLog) {
        StringBuilder sb = new StringBuilder();
        for(int i=1; i<numLog.length; i++){
            int rs = numLog[i]-numLog[i-1];
            if(rs==1) sb.append("w");
            else if(rs==-1) sb.append("s");
            else if(rs>1) sb.append("d");
            else sb.append("a");
        }
        return sb.toString();
    }
}