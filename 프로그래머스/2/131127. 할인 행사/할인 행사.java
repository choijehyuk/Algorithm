import java.util.*;
import java.io.*;

class Solution {
    static HashMap<String, Integer> map = new HashMap<>();
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        
        for(int i = 0; i < want.length; i++) {
            map.put(want[i], i);
        }
        
        for(int i = 0; i < 10; i++) {
            String word = discount[i];
            
            int idx = map.getOrDefault(word, -1);
            
            if(idx >= 0 ) {
                number[idx] -= 1;
            }            
        }
    
        
        boolean flag = true;
        for(int i = 0; i < number.length; i++) {
            if(number[i] > 0) flag = false;
        }
        
        if(flag) answer++;
        
        if(discount.length > 10) {
            for(int i = 10; i < discount.length; i++) {
                String word = discount[i - 10] ;
                
                int idx = map.getOrDefault(word, -1);
                
                if(idx >= 0 ) {
                    number[idx] ++;
                }
                
                String newWord = discount[i];
                
                idx = map.getOrDefault(newWord, -1);
                
                if(idx >= 0) {
                    number[idx]--;
                }
                
                boolean newFlag = true;
                for(int j = 0; j < number.length; j++) {
                    if(number[j] > 0) newFlag = false;
                }
                
                if(newFlag) {
                    answer++;
                }
            }
        }
        
        return answer;
    }
}