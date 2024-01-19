import java.util.*;
import java.io.*;

class Solution {

    public int solution(String[][] clothes) {
        int answer = 1;
        HashMap<String,Integer> map = new HashMap();
        
        for(int i = 0; i< clothes.length; i++){
            String s = clothes[i][1];
            if(map.containsKey(s)){
                int num = map.get(s);
                map.put(s,num+1);
            }
            else{
                map.put(s,2);
            }
        }
        
        for(String key : map.keySet()){
            answer *= map.get(key);
        }
        answer--;
        
        return answer;
    }
}