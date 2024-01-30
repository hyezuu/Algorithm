class Solution {
    public String solution(String[] id_pw, String[][] db) {
        String id = id_pw[0];
        String pw = id_pw[1];
        for(String[] data : db){
            if(data[0].equals(id)){
                if(data[1].equals(pw)){
                    return "login";
                }
                else return "wrong pw";
            }
        }
        return "fail";
    }
}