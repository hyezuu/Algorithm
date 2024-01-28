import java.util.stream.Collectors;
import java.util.*;

class Solution {
    public String solution(String letter) {
        String morse = "'.-':'a','-...':'b','-.-.':'c','-..':'d','.':'e','..-.':'f',"+
    "'--.':'g','....':'h','..':'i','.---':'j','-.-':'k','.-..':'l',"+
    "'--':'m','-.':'n','---':'o','.--.':'p','--.-':'q','.-.':'r',"+
    "'...':'s','-':'t','..-':'u','...-':'v','.--':'w','-..-':'x',"+
    "'-.--':'y','--..':'z'";
        Map<String, String> map = new HashMap<>();
        String[][] morseArray= Arrays.stream(morse.replace("'","").split(","))
            .map(k -> k.split(":"))
            .toArray(String[][]::new);
        
        for(String[] morsearr : morseArray){
            map.put(morsearr[0], morsearr[1]);
        }
        return Arrays.stream(letter.split(" ")).map(k -> map.get(k)).collect(Collectors.joining());
        
    }
}