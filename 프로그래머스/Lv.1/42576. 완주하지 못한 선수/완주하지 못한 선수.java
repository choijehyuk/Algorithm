import java.util.*;
import java.io.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        Arrays.sort(participant);
        Arrays.sort(completion);
        answer = participant[participant.length-1];
        
        for(int i = 0; i < completion.length; i ++){
            if(!participant[i].equals(completion[i])){
                answer = participant[i];
                break;
            }
        }
        
        return answer;
    }
}