import java.util.*;
import java.io.*;

public class Main {
    static char[] str;
    static int len;
    static boolean[] vis;
    public static void main(String[] args) throws IOException{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));

        str= br.readLine().toCharArray();
        len= str.length;
        vis= new boolean[len];
        zoac(0,len);

    }
    static void zoac(int s, int e){
        int idx=-1 ,min = Integer.MAX_VALUE;
        for(int i=s; i<e; i++){
            if(str[i]<min&&!vis[i]){
                min=str[i];
                idx=i;
            }
        }
        if(idx!=-1){
            StringBuilder sb = new StringBuilder();
            vis[idx] = true;

            for(int i=0;i<len;i++){
                if(vis[i])sb.append(str[i]);
            }
            System.out.println(sb.toString());
            zoac(idx,e);
            zoac(s,idx);
        }
    }
}