import java.util.*;
import java.io.*;

class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        String answer = "Yes";
        
        int oneCnt = 0;
        int twoCnt = 0;
    
        for(int i = 0; i < goal.length; i++){
            
            if(oneCnt < cards1.length && goal[i].equals(cards1[oneCnt])){
                oneCnt++;
            }
            else if(twoCnt < cards2.length && goal[i].equals(cards2[twoCnt])){
                twoCnt++;
            }
            else{
                answer = "No"; 
            }
        }
        return answer;
    }
}