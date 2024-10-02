import java.util.*;

class Solution {
    public String[] solution(String[] files) {
        File[] tmpFile = new File[files.length];
        
        int idx = 0;
        for(String fileName : files){
            tmpFile[idx++] = new File(fileName);
        }
        
        Arrays.sort(tmpFile);
        
        String[] answer = new String[tmpFile.length];
        
        for(int i=0; i<answer.length; i++){
            answer[i] = tmpFile[i].toString();
        }
        
        return answer;
    }
}
class File implements Comparable<File>{
    String head;
    String number;
    String tail;
    
    public File(String fileName){
        int i=0, len = fileName.length();
        
        while(i<len && !Character.isDigit(fileName.charAt(i))){
            i++;
        }
        this.head = fileName.substring(0, i);
        
        int numStart = i;
        while(i<len && Character.isDigit(fileName.charAt(i))){
            i++;
        }
        this.number = fileName.substring(numStart, i);
        this.tail = fileName.substring(Math.min(i, fileName.length()));
    }
    
    @Override
    public int compareTo(File o){
        if(this.head.toLowerCase().equals(o.head.toLowerCase())){
            return Integer.parseInt(this.number)-Integer.parseInt(o.number);
        }
        return this.head.toLowerCase().compareTo(o.head.toLowerCase());
    }
    
    @Override
    public String toString(){
        return head+number+tail;
    }
}