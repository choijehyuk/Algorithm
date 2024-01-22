import java.util.*;
import java.io.*;

class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length];
        int[] eng = new int[26];
        Arrays.fill(eng, Integer.MAX_VALUE);
        
        for(int i = 0; i < keymap.length; i++){
            String s = keymap[i];
            for(int j = 1; j <= s.length(); j++){
                char c = s.charAt(j-1);
                eng[c - 'A'] = Math.min(eng[c - 'A'], j);
            }
        }
        
        for(int i = 0; i < eng.length; i++){
            System.out.print(eng[i] + " ");
        }
        
        for(int i = 0; i < targets.length; i++){
            String s = targets[i];
            int sum = 0;
            boolean flag = false;
            for(int j = 0; j < s.length(); j++){
                sum += eng[s.charAt(j) - 'A'];
                if(eng[s.charAt(j) - 'A'] == Integer.MAX_VALUE){
                    flag = true;
                }
            }
            if(flag) answer[i] = -1;
            else answer[i] = sum;
        }
        return answer;
    }
}