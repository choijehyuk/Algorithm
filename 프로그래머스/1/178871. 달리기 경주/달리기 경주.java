import java.util.*;
import java.io.*;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        String[] answer = new String[players.length];
        
        HashMap<String, Integer> map = new HashMap<>();
        HashMap<Integer, String> rankMap = new HashMap<>();
        
        for(int i = 0; i < players.length; i++){
            map.put(players[i],i);
            rankMap.put(i,players[i]);
        }
        
        for(int i = 0; i < callings.length; i++){
            String call = callings[i];
            
            int seq = map.get(call); 
            String change = rankMap.get(seq-1); 
                
            map.put(call,seq-1); 
            rankMap.put(seq-1,call);
                        
            map.put(change,seq);
            rankMap.put(seq,change);
            
            
        }
        
        for(int i = 0; i < map.size(); i++){
            answer[i] = rankMap.get(i);
        }
        return answer;
    }
}