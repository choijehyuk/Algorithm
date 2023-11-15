import java.util.*;
import java.io.*;

class Solution {
    public int[] solution(String s) {
        int[] answer = new int[s.length()];
        
        int[] eng = new int[26];
        Arrays.fill(eng, -1);
        
        for(int i = 0; i < s.length(); i++){
            answer[i] = eng[s.charAt(i) - 'a'];
            eng[s.charAt(i) - 'a'] = 0;
            
            for(int j = 0; j <eng.length; j++){
                if(eng[j] != -1){
                    eng[j]++;
                }
            }

            
        }
        return answer;
    }
}